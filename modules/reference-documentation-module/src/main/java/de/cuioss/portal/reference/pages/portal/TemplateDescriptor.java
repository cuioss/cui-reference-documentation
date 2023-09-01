package de.cuioss.portal.reference.pages.portal;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jdom2.Comment;
import org.jdom2.Content;
import org.jdom2.Content.CType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import de.cuioss.tools.io.IOStreams;
import de.cuioss.tools.string.MoreStrings;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Parses the given xhtml, checks for the first comment. If it starts with
 * {@link #DOCUMENTATION_START_ELEMENT} and ends with
 * {@link #DOCUMENTATION_END_ELEMENT} it treats it as a documentation block. It
 * parses the the documentation block and extracts the direct text-child of
 * {@link #DOCUMENTATION_START_ELEMENT} and use it as #getDescription() . In
 * addition it extracts all {@link #SECTION_ELEMENT} and creates an
 * {@link Section} therefore. With Section#getName() derived by the
 * {@link #TITLE_ELEMENT} and Section#getContent()
 *
 * @author Oliver Wolff
 */
@ToString
@EqualsAndHashCode
public class TemplateDescriptor implements Serializable {

    private static final long serialVersionUID = 4592575935978094487L;

    private static final String NO_DECRIPTION_FOUND = "No decription found";

    /** */
    public static final String DOCUMENTATION_START_ELEMENT = "<documentation>";
    /** */
    public static final String DOCUMENTATION_END_ELEMENT = "</documentation>";
    /** */
    public static final String SECTION_ELEMENT = "section";

    /** */
    public static final String BODY_ELEMENT = "body";

    /** */
    public static final String TITLE_ELEMENT = "title";

    @Getter
    private final String usagePath;

    @Getter
    private final String fullPath;

    @Getter
    private final String description;

    @Getter
    private final List<Section> sections;

    /**
     * @param usagePath
     * @param fullPath
     */
    public TemplateDescriptor(final String usagePath, final String fullPath) {
        final var comments = extractComments(fullPath);
        this.usagePath = usagePath;
        this.fullPath = fullPath;
        if (comments.isEmpty()) {
            description = NO_DECRIPTION_FOUND;
            sections = Collections.emptyList();
        } else {
            final var wrappedComment = wrappDescription(comments.iterator().next());
            description = extractDescription(wrappedComment);
            sections = extractSections(wrappedComment);
        }
    }

    private static List<Comment> extractComments(final String fullPath) {
        final var resource = TemplateDescriptor.class.getResource(fullPath);
        Document document = null;
        try {
            document = new SAXBuilder().build(resource);
        } catch (JDOMException | IOException e) {
            throw new IllegalStateException("Unable to parse file " + fullPath, e);
        }
        final var root = document.getRootElement();
        final List<Comment> found = new ArrayList<>();

        final var contentElements = root.getContent();
        for (final Content content : contentElements) {
            if (CType.Comment.equals(content.getCType())) {
                found.add((Comment) content);
            }
        }
        return found;
    }

    private static Element wrappDescription(final Comment comment) {
        if (null == comment || MoreStrings.isEmpty(comment.getText())) {
            return null;
        }
        final var commentString = comment.getText().trim();
        if (commentString.startsWith(DOCUMENTATION_START_ELEMENT)
                && commentString.endsWith(DOCUMENTATION_END_ELEMENT)) {
            Document document = null;
            try (var inputStream = IOStreams.toInputStream(commentString)) {
                document = new SAXBuilder().build(inputStream);
            } catch (JDOMException | IOException e) {
                throw new IllegalStateException("Unable to parse xhtml", e);
            }
            return document.getRootElement();
        }

        return null;
    }

    private static List<Section> extractSections(final Element wrappedComment) {
        if (null == wrappedComment) {
            return Collections.emptyList();
        }
        final var extractedSections = wrappedComment.getChildren(SECTION_ELEMENT);
        final List<Section> result = new ArrayList<>();
        for (final Element extractedSection : extractedSections) {
            result.add(new Section(extractedSection.getChildText(TITLE_ELEMENT),
                    new XMLOutputter().outputString(extractedSection.getChild(BODY_ELEMENT).getContent())));
        }
        return result;
    }

    private static String extractDescription(final Element wrappedComment) {
        if (null == wrappedComment) {
            return NO_DECRIPTION_FOUND;
        }
        final var childText = wrappedComment.getChild(BODY_ELEMENT);
        if (null != childText) {
            return new XMLOutputter().outputString(childText.getContent());
        }
        return null;
    }

}
