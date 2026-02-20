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

import de.cuioss.portal.ui.test.junit5.EnablePortalUiEnvironment;
import de.cuioss.test.valueobjects.junit5.contracts.ShouldHandleObjectContracts;
import jakarta.inject.Inject;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnablePortalUiEnvironment
class CuiTagResolverTest implements ShouldHandleObjectContracts<CuiTagResolver> {

    @Inject
    @Getter
    CuiTagResolver underTest;

    @Test
    void shouldProvideLibraries() {
        underTest.initBean();

        assertNotNull(underTest.getCuiTagLib());
        assertNotNull(underTest.getCuiBootstrapTagLib());
        assertNotNull(underTest.getJsfCoreTagLib());
        assertNotNull(underTest.getJsfHtmlTagLib());
        assertNotNull(underTest.getOmniTagLib());
        assertNotNull(underTest.getPrimeTagLib());
    }

}
