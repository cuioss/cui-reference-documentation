package de.cuioss.portal.reference.portal;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.inject.Inject;

import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import de.cuioss.portal.ui.api.templating.PortalTemplateDescriptor;
import de.cuioss.test.valueobjects.junit5.contracts.ShouldBeNotNull;
import de.cuioss.tools.io.FileLoaderUtility;
import lombok.Getter;

@EnableAutoWeld
class ReferenceTemplatesTest implements ShouldBeNotNull<ReferenceTemplates> {

    @Inject
    @PortalTemplateDescriptor
    @Getter
    private ReferenceTemplates underTest;

    @Test
    void templatesShoultBeAccessible() {
        for (String template : underTest.getHandledTemplates()) {
            var loader = FileLoaderUtility.getLoaderForPath(underTest.getTemplatePath() + '/' + template);
            assertTrue(loader.isReadable(), template);
        }
    }

}
