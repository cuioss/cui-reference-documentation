package de.cuioss.portal.reference.pages.components.demo;

import javax.inject.Inject;

import de.cuioss.portal.ui.test.junit5.EnablePortalUiEnvironment;
import de.cuioss.portal.ui.test.tests.AbstractPageBeanTest;
import lombok.Getter;

@EnablePortalUiEnvironment
class PanelDemoProviderTest extends AbstractPageBeanTest<PanelDemoProvider> {

    @Inject
    @Getter
    private PanelDemoProvider underTest;

}
