package de.cuioss.portal.reference.pages;

import de.cuioss.test.juli.LogAsserts;
import de.cuioss.test.juli.TestLogLevel;
import de.cuioss.test.juli.junit5.EnableTestLogger;
import jakarta.inject.Inject;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableAutoWeld
@EnableTestLogger
class ConfigDocuBeanTest {

    @Inject
    ConfigDocuBean underTest;

    @Test
    void shouldLoadConfigFiles() {
        final var result = underTest.getDefaultConfigSources();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertNotNull(result.get(0).getPath());
        assertNotNull(result.get(0).getLang());
        LogAsserts.assertNoLogMessagePresent(TestLogLevel.ERROR, ConfigDocuBean.class);
    }
}
