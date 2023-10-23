package de.cuioss.portal.reference.portal.application;

import java.util.Optional;

import javax.annotation.Priority;
import javax.enterprise.context.Dependent;

import de.cuioss.portal.common.bundle.ResourceBundleLocator;
import de.cuioss.portal.common.priority.PortalPriorities;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Defines the additional bundle "reference_msg"
 *
 * @author Oliver Wolff
 */
@Dependent
@Priority(PortalPriorities.PORTAL_MODULE_LEVEL)
@EqualsAndHashCode
@ToString
public class BundleNames implements ResourceBundleLocator {

    private static final long serialVersionUID = -570736967563631611L;

    @Override
    public Optional<String> getBundlePath() {
        return Optional.of("de.cuioss.portal.reference.i18n.messages");
    }

}
