package de.cuioss.portal.reference.pages.portal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.cuioss.portal.ui.api.templating.PortalTemplateDescriptor;
import de.cuioss.portal.ui.runtime.application.templating.PortalTemplates;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Oliver Wolff
 */
@Named
@ApplicationScoped
@EqualsAndHashCode
@ToString
public class PortalTemplateBean implements Serializable {

    private static final long serialVersionUID = 638283726301069378L;

    private static final String TEMPLATE_BASE_PATH = "/META-INF/templates/portal/";
    private static final String TEMPLATE_USAGE_PATH = "/templates/";

    @Inject
    @PortalTemplateDescriptor
    PortalTemplates portalTemplates;

    @Getter
    private List<TemplateDescriptor> templateDescriptor;

    /**
     *
     */
    @PostConstruct
    public void init() {
        this.templateDescriptor = new ArrayList<>();
        for (final String path : this.portalTemplates.getHandledTemplates()) {
            this.templateDescriptor.add(new TemplateDescriptor(TEMPLATE_USAGE_PATH + path, TEMPLATE_BASE_PATH + path));
        }
    }
}
