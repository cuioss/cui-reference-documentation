package de.cuioss.portal.reference.pages;

import java.io.Serial;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import de.cuioss.jsf.dev.metadata.TagLib;
import de.cuioss.jsf.dev.metadata.model.UIComponentMetadata;
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
public class CuiTagResolver implements Serializable {

    @Serial
    private static final long serialVersionUID = 5547311337444854287L;

    private static final String TAGLIB = "/META-INF/cui-core.taglib.xml";
    private static final String CUI_BOOTSTRAP = "/META-INF/cui-bootstrap.taglib.xml";

    private static final String OMNIFACES = "/META-INF/omnifaces-ui.taglib.xml";

    private static final String PRIMEFACES = "/META-INF/primefaces-p.taglib.xml";

    private static final String JSF_HTML = "/META-INF/myfaces_html.tld";

    private static final String JSF_CORE = "/META-INF/myfaces_core.tld";

    @Getter
    private TagLib cuiTagLib;

    @Getter
    private TagLib cuiBootstrapTagLib;

    @Getter
    private TagLib omniTagLib;

    @Getter
    private TagLib primeTagLib;

    @Getter
    private TagLib jsfHtmlTagLib;

    @Getter
    private TagLib jsfCoreTagLib;

    @PostConstruct
    public void initBean() {
        cuiTagLib = new TagLib(TAGLIB, TagLib.JSF_2_2_FACELET_TAGLIB_NAMESPACE);
        cuiBootstrapTagLib = new TagLib(CUI_BOOTSTRAP, TagLib.JSF_2_2_FACELET_TAGLIB_NAMESPACE);
        omniTagLib = new TagLib(OMNIFACES, TagLib.JSF_2_2_FACELET_TAGLIB_NAMESPACE);
        primeTagLib = new TagLib(PRIMEFACES, TagLib.JSF_2_FACELET_TAGLIB_NAMESPACE);
        jsfHtmlTagLib = new TagLib(JSF_HTML, TagLib.JSF_2_2_FACELET_TAGLIB_NAMESPACE);
        jsfCoreTagLib = new TagLib(JSF_CORE, TagLib.JSF_2_2_FACELET_TAGLIB_NAMESPACE);

    }

    public UIComponentMetadata getCuiComponentByName(final String name) {
        return cuiTagLib.getComponentMetadata().getByName(name).orElse(cuiBootstrapTagLib.getComponentMetadata().getByName(name).orElse(null));
    }
}
