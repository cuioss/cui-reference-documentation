package de.cuioss.portal.reference.pages;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

import de.cuioss.portal.ui.test.junit5.EnablePortalUiEnvironment;
import de.cuioss.test.valueobjects.junit5.contracts.ShouldHandleObjectContracts;
import lombok.Getter;

@EnablePortalUiEnvironment
class CuiTagResolverTest implements ShouldHandleObjectContracts<CuiTagResolver> {

    @Inject
    @Getter
    CuiTagResolver underTest;

    @Test
    void shouldProvideLibraries() {
        underTest.initBean();

        assertNotNull(underTest.getCuiTagLib());
        assertNotNull(underTest.getCuiBootstrapTagLib());
        assertNotNull(underTest.getJsfCoreTagLib());
        assertNotNull(underTest.getJsfHtmlTagLib());
        assertNotNull(underTest.getOmniTagLib());
        assertNotNull(underTest.getPrimeTagLib());
    }

}
