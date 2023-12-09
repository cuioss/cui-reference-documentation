package de.cuioss.portal.reference.pages;

import org.jboss.weld.environment.se.Weld;

import de.cuioss.portal.core.test.tests.BaseModuleConsistencyTest;
import de.cuioss.test.jsf.producer.ServletObjectsFromJSFContextProducer;

class ModuleConsistencyTest extends BaseModuleConsistencyTest {

    @Override
    protected Weld modifyWeldContainer(Weld weld) {
        return weld.enableDevMode().addBeanClass(ServletObjectsFromJSFContextProducer.class);
    }
}
