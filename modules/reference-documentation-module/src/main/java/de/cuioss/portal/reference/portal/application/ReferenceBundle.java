package de.cuioss.portal.reference.portal.application;

import java.util.Optional;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;

import de.cuioss.portal.common.bundle.ResourceBundleLocator;
import de.cuioss.portal.common.priority.PortalPriorities;
import lombok.EqualsAndHashCode;

/**
 * Defines the additional bundle
 *
 * @author Oliver Wolff
 */
@ApplicationScoped
@Priority(PortalPriorities.PORTAL_MODULE_LEVEL)
@EqualsAndHashCode
public class ReferenceBundle implements ResourceBundleLocator {

//    private static final String PATH = "de.portal-messages";
    private static final String PATH = "de.cuioss.portal.reference.i18n.reference_messages";
//    private static final String PATH = "de.cuioss.portal.ui.i18n.portal-messages";
//    private static final String PATH = "de.cuioss.portal.ui.i18n.jsf_messages";
    private static final long serialVersionUID = -570736967563631611L;

    @Override
    public Optional<String> getBundlePath() {
        return Optional.of(PATH);
    }

    @Override
    public String toString() {
        return "%s: Path='%s'".formatted(getClass().getName(), PATH);
    }

}
