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
        jsfHtmlTagLib = LibraryTagLib.FACES_HTML.load();
        jsfCoreTagLib = LibraryTagLib.FACES_CORE.load();

    }

    public UIComponentMetadata getCuiComponentByName(final String name) {
        return cuiTagLib.getComponentMetadata().getByName(name).orElse(cuiBootstrapTagLib.getComponentMetadata().getByName(name).orElse(null));
    }
}
