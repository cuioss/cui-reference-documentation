package de.cuioss.portal.reference.pages;

import de.cuioss.jsf.api.application.message.MessageProducer;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author i001456
 */
@Named
@RequestScoped
@ToString
@EqualsAndHashCode
public class PrimeFacesIconsOverviewPageBean implements Serializable {

    private static final String CSS_BEFORE = ":before";

    private static final String CUI_ICON_PREFIX = "ui-icon-";

    private static final String RESOURCE_NAME = "icons.css";

    private static final String LIBRARY_NAME = "com.icw.portal.css";

    private static final String DUPLICATE_WARN_MSG_KEY = "java.CuiIconsOverviewPageBean.warning.duplicate.style";

    @Serial
    private static final long serialVersionUID = -6584517051621040849L;

    @Getter
    private List<String> data;

    @Inject
    FacesContext facesContext;

    @Inject
    MessageProducer messageProducer;

    /**
     * This intiializer is used to insert the new cui-icon those already generated
     * with IcoMoon application from Google. To create a new cui-icon read the Wiki
     * page: https://wiki.icw.int/display/DOC/Web+Font+Icons The icons.css will be
     * tested if there is a duplicated cui-icon therefore an error message will be
     * shown in the cui_icon.jsf including the duplicated icons.
     */
    @PostConstruct
    public void initBean() {
        data = new IconExtractor(CSS_BEFORE, CUI_ICON_PREFIX, DUPLICATE_WARN_MSG_KEY, facesContext, messageProducer)
            .fromResource(RESOURCE_NAME, LIBRARY_NAME);
    }
}
