package de.cuioss.portal.reference.portal;

import de.cuioss.portal.common.priority.PortalPriorities;
import de.cuioss.portal.ui.api.templating.PortalTemplateDescriptor;
import de.cuioss.portal.ui.api.templating.StaticTemplateDescriptor;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.util.List;

import static de.cuioss.tools.collect.CollectionLiterals.immutableList;

/**
 * Provides a base template for the reference-documentation pages
 *
 * @author Oliver Wolff
 */
@PortalTemplateDescriptor
@Dependent
@Priority(PortalPriorities.PORTAL_MODULE_LEVEL)
@EqualsAndHashCode
@ToString
@Named
public class ReferenceTemplates implements StaticTemplateDescriptor {

    @Serial
    private static final long serialVersionUID = 1933293647595996193L;

    @Getter
    private final List<String> handledTemplates = immutableList("layout_portal_core.xhtml",
        "layout_portal_clients.xhtml", "layout_portal_labeledContainer.xhtml");

    private static final String PATH = "classpath:META-INF/templates/reference";

    @Override
    public String getTemplatePath() {
        return PATH;
    }

}
