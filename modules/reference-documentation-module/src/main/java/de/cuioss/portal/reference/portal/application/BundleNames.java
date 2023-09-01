package de.cuioss.portal.reference.portal.application;

import static de.cuioss.tools.collect.CollectionLiterals.immutableList;

import java.util.List;

import javax.annotation.Priority;
import javax.enterprise.context.Dependent;

import de.cuioss.portal.configuration.bundles.PortalResourceBundleLocator;
import de.cuioss.portal.configuration.bundles.ResourceBundleLocator;
import de.cuioss.portal.configuration.common.PortalPriorities;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Defines the additional bundle "reference_msg"
 *
 * @author Oliver Wolff
 */
@PortalResourceBundleLocator
@Dependent
@Priority(PortalPriorities.PORTAL_MODULE_LEVEL)
@EqualsAndHashCode
@ToString
public class BundleNames implements ResourceBundleLocator {

    private static final long serialVersionUID = -570736967563631611L;

    @Getter
    private final List<String> configuredResourceBundles = immutableList("de.cuioss.portal.reference.i18n.messages");

}
