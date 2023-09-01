package de.cuioss.portal.reference.pages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import de.cuioss.jsf.api.application.message.MessageProducer;
import de.cuioss.tools.logging.CuiLogger;
import de.cuioss.tools.string.MoreStrings;
import de.cuioss.tools.string.Splitter;

@SuppressWarnings("javadoc")
public class IconExtractor {

    private final MessageProducer messageProducer;

    private static final CuiLogger log = new CuiLogger(IconExtractor.class);

    private final FacesContext facesContext;

    private final String cssBefore;

    private final String cuiIconPrefix;

    private final String warnOnDuplicateMessageKey;

    public IconExtractor(final String cssBefore, final String cuiIconPrefix, final String warnOnDuplicateMessageKey,
            final FacesContext facesContext, final MessageProducer messageProducer) {
        this.facesContext = facesContext;
        this.messageProducer = messageProducer;
        this.cssBefore = cssBefore;
        this.cuiIconPrefix = cuiIconPrefix;
        this.warnOnDuplicateMessageKey = warnOnDuplicateMessageKey;
    }

    public List<String> fromResource(final String resourceName, final String libraryName) {
        final var resource = facesContext.getApplication().getResourceHandler().createResource(resourceName,
                libraryName);

        final List<String> data = new ArrayList<>();

        try (final var reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            final var splitter = Splitter.on(".").omitEmptyStrings().trimResults();
            String line;

            while ((line = reader.readLine()) != null) {
                final var splitted = splitter.splitToList(line);
                addIconsToDataList(splitted, data);
            }
        } catch (final IOException e) {
            log.error("IOException", e);
        }

        return data;
    }

    private void addIconsToDataList(final List<String> splitted, final List<String> data) {
        for (final String part : splitted) {
            if (containsCuiIcon(part)) {
                final var styleClass = extractStyleClass(part);
                if (!data.contains(styleClass) && !"cui-icon-white".equals(styleClass)
                        && !"cui-icon-red".equals(styleClass)) {
                    data.add(styleClass);
                } else {
                    warnOnDuplicate(facesContext, styleClass);
                }
            }
        }
    }

    private String extractStyleClass(final String line) {
        final var beginIndex = line.indexOf(cuiIconPrefix);
        final var endIndex = line.indexOf(cssBefore);
        return line.substring(beginIndex, endIndex).replace(".", "");
    }

    private boolean containsCuiIcon(final String line) {
        return !MoreStrings.isEmpty(line) && line.contains(cuiIconPrefix) && line.contains(cssBefore);
    }

    private void warnOnDuplicate(final FacesContext context, final String styleClass) {
        final var errorMessage = messageProducer.getErrorMessageFor(warnOnDuplicateMessageKey, styleClass);
        context.addMessage(null, errorMessage);
        log.warn("Duplicate icon style for {} found", styleClass);
    }
}
