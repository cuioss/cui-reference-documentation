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
package de.cuioss.portal.reference.portal;

import de.cuioss.portal.ui.api.templating.PortalTemplateDescriptor;
import de.cuioss.test.valueobjects.junit5.contracts.ShouldBeNotNull;
import de.cuioss.tools.io.FileLoaderUtility;
import jakarta.inject.Inject;
import lombok.Getter;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableAutoWeld
class ReferenceTemplatesTest implements ShouldBeNotNull<ReferenceTemplates> {

    @Inject
    @PortalTemplateDescriptor
    @Getter
    ReferenceTemplates underTest;

    @Test
    void templatesShoultBeAccessible() {
        for (String template : underTest.getHandledTemplates()) {
            var loader = FileLoaderUtility.getLoaderForPath(underTest.getTemplatePath() + '/' + template);
            assertTrue(loader.isReadable(), template);
        }
    }

}
