package de.cuioss.portal.reference.pages;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import jakarta.inject.Inject;

import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import de.cuioss.test.juli.LogAsserts;
import de.cuioss.test.juli.TestLogLevel;
import de.cuioss.test.juli.junit5.EnableTestLogger;

@EnableAutoWeld
@EnableTestLogger
class ConfigDocuBeanTest {

    @Inject
    ConfigDocuBean underTest;

    @Test
    @Disabled("@Sven: ich habe das ant-Zeugs nicht verstanden")
    void defaultConfigLoaded() {
        final var result = underTest.getDefaultConfigSources();
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertNotNull(result.get(0).getPath());
        assertNotNull(result.get(0).getModuleName());
        assertFalse(result.get(0).getModuleName().contains("/"));
        assertFalse(result.get(0).getModuleName().contains("\\"));
        assertNotNull(result.get(0).getLang());
        LogAsserts.assertNoLogMessagePresent(TestLogLevel.ERROR, ConfigDocuBean.class);
    }
}
