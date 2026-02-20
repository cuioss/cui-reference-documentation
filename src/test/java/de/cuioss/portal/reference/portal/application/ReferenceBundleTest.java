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
package de.cuioss.portal.reference.portal.application;

import de.cuioss.portal.common.bundle.PortalResourceBundleBean;
import de.cuioss.portal.common.bundle.ResourceBundleWrapper;
import de.cuioss.portal.common.bundle.ResourceBundleWrapperImpl;
import de.cuioss.portal.ui.test.mocks.PortalLocaleProducerMock;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import org.jboss.weld.junit5.auto.ActivateScopes;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableAutoWeld
@AddBeanClasses({ReferenceBundle.class, PortalResourceBundleBean.class, ResourceBundleWrapperImpl.class,
    PortalLocaleProducerMock.class})
@ActivateScopes({RequestScoped.class, SessionScoped.class})
class ReferenceBundleTest {

    @Inject
    ResourceBundleWrapper bundleWrapper;

    @Test
    void shouldProvideKey() {
        assertTrue(bundleWrapper.keySet().contains("navigation.menue.bootstrap"));
        assertEquals("Twitter Bootstrap", bundleWrapper.getString("navigation.menue.bootstrap"));
    }

}
