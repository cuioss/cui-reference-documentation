package de.cuioss.portal.reference.pages;

import de.cuioss.portal.core.test.tests.BaseModuleConsistencyTest;
import de.cuioss.test.jsf.producer.ServletObjectsFromJSFContextProducer;
import org.jboss.weld.environment.se.Weld;

class ModuleConsistencyTest extends BaseModuleConsistencyTest {

    @Override
    protected Weld modifyWeldContainer(Weld weld) {
        return weld.addBeanClass(ServletObjectsFromJSFContextProducer.class);
    }
}
