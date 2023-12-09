package de.cuioss.portal.reference.portal.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import org.jboss.weld.junit5.auto.ActivateScopes;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import de.cuioss.portal.common.bundle.PortalResourceBundleBean;
import de.cuioss.portal.common.bundle.ResourceBundleWrapper;
import de.cuioss.portal.common.bundle.ResourceBundleWrapperImpl;
import de.cuioss.portal.ui.test.mocks.PortalLocaleProducerMock;

@EnableAutoWeld
@AddBeanClasses({ ReferenceBundle.class, PortalResourceBundleBean.class, ResourceBundleWrapperImpl.class,
        PortalLocaleProducerMock.class })
@ActivateScopes({ RequestScoped.class, SessionScoped.class })
class ReferenceBundleTest {

    @Inject
    private ResourceBundleWrapper bundleWrapper;

    @Test
    void shouldProvideKey() {
        assertTrue(bundleWrapper.keySet().contains("navigation.menue.bootstrap"));
        assertEquals("Twitter Bootstrap", bundleWrapper.getString("navigation.menue.bootstrap"));
    }

}
