package de.cuioss.portal.reference.pages.components.demo;

import javax.inject.Inject;

import org.jboss.weld.junit5.auto.AddBeanClasses;

import de.cuioss.portal.core.test.mocks.authentication.PortalAuthenticationFacadeMock;
import de.cuioss.portal.core.test.mocks.authentication.PortalTestUserProducer;
import de.cuioss.portal.ui.test.junit5.EnablePortalUiEnvironment;
import de.cuioss.portal.ui.test.tests.AbstractPageBeanTest;
import lombok.Getter;

@EnablePortalUiEnvironment
@AddBeanClasses({ PortalAuthenticationFacadeMock.class, PortalTestUserProducer.class })
class NavigationMenuDemoBeanTest extends AbstractPageBeanTest<NavigationMenuDemoBean> {

    @Inject
    @Getter
    private NavigationMenuDemoBean underTest;

}
