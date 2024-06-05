package de.cuioss.portal.reference.pages;

import de.cuioss.jsf.dev.metadata.LibraryTagLib;
import de.cuioss.jsf.dev.metadata.TagLib;
import de.cuioss.jsf.dev.metadata.model.UIComponentMetadata;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

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
        cuiTagLib = LibraryTagLib.CUI_CORE.load();
        cuiBootstrapTagLib = LibraryTagLib.CUI_BOOTSTRAP.load();
        omniTagLib = LibraryTagLib.OMNI_FACES.load();
        primeTagLib = LibraryTagLib.PRIME_FACES.load();
        jsfHtmlTagLib = LibraryTagLib.MY_FACES.load();
        jsfCoreTagLib = LibraryTagLib.MY_FACES.load();

    }

    public UIComponentMetadata getCuiComponentByName(final String name) {
        return cuiTagLib.getComponentMetadata().getByName(name).orElse(cuiBootstrapTagLib.getComponentMetadata().getByName(name).orElse(null));
    }
}
