/*
 * Copyright © 2025 CUI-OpenSource-Software (info@cuioss.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.cuioss.portal.reference.pages;

import de.cuioss.jsf.api.application.message.MessageProducer;
import de.cuioss.tools.logging.CuiLogger;
import de.cuioss.tools.string.MoreStrings;
import de.cuioss.tools.string.Splitter;
import jakarta.faces.context.FacesContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IconExtractor {

    private final MessageProducer messageProducer;

    private static final CuiLogger LOGGER = new CuiLogger(IconExtractor.class);

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
            // cui-rewrite:disable CuiLogRecordPatternRecipe
            LOGGER.error(e, "IOException");
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
        // cui-rewrite:disable CuiLogRecordPatternRecipe
        LOGGER.warn("Duplicate icon style for %s found", styleClass);
    }
}
