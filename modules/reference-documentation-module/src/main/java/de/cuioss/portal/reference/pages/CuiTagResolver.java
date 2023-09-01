package de.cuioss.portal.reference.pages;

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

    private static final long serialVersionUID = 5547311337444854287L;

    private static final String TAGLIB = "/META-INF/commons-webui.taglib.xml";

    private static final String OMNIFACES = "/META-INF/omnifaces-ui.taglib.xml";

    private static final String PRIMEFACES = "/META-INF/primefaces-p.taglib.xml";

    private static final String MOJARRA_HTML = "/com/sun/faces/metadata/taglib/html_basic.taglib.xml";

    private static final String MOJARRA_CORE = "/com/sun/faces/metadata/taglib/facelets_jsf_core.taglib.xml";

    private static final String MOJARRA_UI = "/com/sun/faces/metadata/taglib/ui.taglib.xml";

    @Getter
    private TagLib cuiTagLib;

    @Getter
    private TagLib omniTagLib;

    @Getter
    private TagLib primeTagLib;

    @Getter
    private TagLib mojarraHtmlTagLib;

    @Getter
    private TagLib mojarraCoreTagLib;

    @Getter
    private TagLib mojarraUiTagLib;

    @PostConstruct
    public void initBean() {
        cuiTagLib = new TagLib(TAGLIB, TagLib.JSF_2_2_FACELET_TAGLIB_NAMESPACE);
        omniTagLib = new TagLib(OMNIFACES, TagLib.JSF_2_2_FACELET_TAGLIB_NAMESPACE);
        primeTagLib = new TagLib(PRIMEFACES, TagLib.JSF_2_FACELET_TAGLIB_NAMESPACE);
        mojarraHtmlTagLib = new TagLib(MOJARRA_HTML, TagLib.JSF_2_2_FACELET_TAGLIB_NAMESPACE);
        mojarraCoreTagLib = new TagLib(MOJARRA_CORE, TagLib.JSF_2_2_FACELET_TAGLIB_NAMESPACE);
        mojarraUiTagLib = new TagLib(MOJARRA_UI, TagLib.JSF_2_2_FACELET_TAGLIB_NAMESPACE);

    }

    public UIComponentMetadata getCuiComponentByName(final String name) {
        return cuiTagLib.getComponentMetadata().getByName(name);
    }
}
