package de.cuioss.portal.reference.pages.components.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

import de.cuioss.portal.ui.test.junit5.EnablePortalUiEnvironment;
import de.cuioss.portal.ui.test.tests.AbstractPageBeanTest;
import lombok.Getter;

@EnablePortalUiEnvironment
class DialogDemoPageBeanTest extends AbstractPageBeanTest<DialogDemoPageBean> {

    @Inject
    @Getter
    private DialogDemoPageBean underTest;

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
