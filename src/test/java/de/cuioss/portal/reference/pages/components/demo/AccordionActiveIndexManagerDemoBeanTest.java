package de.cuioss.portal.reference.pages.components.demo;

import jakarta.inject.Inject;

import de.cuioss.portal.ui.test.junit5.EnablePortalUiEnvironment;
import de.cuioss.portal.ui.test.tests.AbstractPageBeanTest;
import de.cuioss.test.valueobjects.api.object.ObjectTestConfig;
import lombok.Getter;

@EnablePortalUiEnvironment
@ObjectTestConfig(equalsAndHashCodeBasicOnly = true)
class AccordionActiveIndexManagerDemoBeanTest extends AbstractPageBeanTest<AccordionActiveIndexManagerDemoBean> {

    @Inject
    @Getter
    AccordionActiveIndexManagerDemoBean underTest;

}
