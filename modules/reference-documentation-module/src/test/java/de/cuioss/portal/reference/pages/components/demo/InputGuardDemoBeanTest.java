package de.cuioss.portal.reference.pages.components.demo;

import javax.inject.Inject;

import de.cuioss.portal.ui.test.junit5.EnablePortalUiEnvironment;
import de.cuioss.portal.ui.test.tests.AbstractPageBeanTest;
import de.cuioss.test.valueobjects.api.contracts.VerifyBeanProperty;
import de.cuioss.test.valueobjects.api.property.PropertyReflectionConfig;
import lombok.Getter;

@EnablePortalUiEnvironment
@VerifyBeanProperty
@PropertyReflectionConfig(exclude = "inputList")
class InputGuardDemoBeanTest extends AbstractPageBeanTest<InputGuardDemoBean> {

    @Inject
    @Getter
    private InputGuardDemoBean underTest;

}
