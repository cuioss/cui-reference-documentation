package de.cuioss.portal.reference.pages.components.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import de.cuioss.portal.ui.test.junit5.EnablePortalUiEnvironment;
import de.cuioss.portal.ui.test.tests.AbstractPageBeanTest;
import lombok.Getter;

@EnablePortalUiEnvironment
class EditableDataListDemoPageBeanTest extends AbstractPageBeanTest<EditableDataListDemoPageBean> {

    @Inject
    @Getter
    private EditableDataListDemoPageBean underTest;

    @Test
    void shouldHaveModel() {
        assertNotNull(underTest.getAddressModel());
        assertFalse(underTest.getAddressModel().getLoadedItems().isEmpty());
    }
}
