package de.cuioss.portal.reference.pages.portal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import de.cuioss.portal.ui.test.junit5.EnablePortalUiEnvironment;
import de.cuioss.portal.ui.test.tests.AbstractPageBeanTest;
import lombok.Getter;

@EnablePortalUiEnvironment
class PortalTemplateBeanTest extends AbstractPageBeanTest<PortalTemplateBean> {

    @Inject
    @Getter
    private PortalTemplateBean underTest;

    @Test
    void shouldProvideContent() {
        assertEquals(7, underTest.getTemplateDescriptor().size());
    }

}
