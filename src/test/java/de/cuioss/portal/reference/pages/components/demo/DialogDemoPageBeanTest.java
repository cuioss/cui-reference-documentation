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
package de.cuioss.portal.reference.pages.components.demo;

import de.cuioss.portal.ui.test.junit5.EnablePortalUiEnvironment;
import de.cuioss.portal.ui.test.tests.AbstractPageBeanTest;
import jakarta.inject.Inject;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnablePortalUiEnvironment
class DialogDemoPageBeanTest extends AbstractPageBeanTest<DialogDemoPageBean> {

    @Inject
    @Getter
    DialogDemoPageBean underTest;

    @Test
    void shouldInitData() {
        assertFalse(underTest.isLazyLoadingDialogContentAvailable());
        underTest.initLazyLoadingDialogContent();
        assertTrue(underTest.isLazyLoadingDialogContentAvailable());
    }

    @Test
    void shouldShowAndHideDialog() {
        assertFalse(underTest.isRenderLazyLoadingDialogContent());
        underTest.showLazyLoadingDialog();
        assertTrue(underTest.isRenderLazyLoadingDialogContent());
        underTest.hideLazyLoadingDialog();
        assertFalse(underTest.isRenderLazyLoadingDialogContent());
    }
}
