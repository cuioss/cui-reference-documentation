package de.cuioss.portal.reference.portal.application;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;

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
    private static final long serialVersionUID = -570736967563631611L;
    private static final String PATH = "de.cuioss.portal.reference.i18n.reference";

    @Override
    public Optional<String> getBundlePath() {
        return Optional.of(PATH);
    }

    @Override
    public String toString() {
        return "%s: Path='%s'".formatted(getClass().getName(), PATH);
    }

    /**
     * This is needed in the context of a quarkus module: Otherwise the
     * {@link ResourceBundle} can not be found. The difference to the default
     * implementation is passing
     * {@code Thread.currentThread().getContextClassLoader()}
     */
    @Override
    public Optional<ResourceBundle> getBundle(Locale locale) {
        try {
            Optional<ResourceBundle> loadedBundle = Optional
                    .of(ResourceBundle.getBundle(PATH, locale, Thread.currentThread().getContextClassLoader()));
            LOGGER.debug("Successfully loaded %s '%s' for '%s'", getClass().getName(), PATH, locale);
            return loadedBundle;
        } catch (MissingResourceException e) {
            LOGGER.warn("Unable to load %s '%s' for '%s'".formatted(getClass().getName(), PATH, locale), e);
            return Optional.empty();
        }
    }

}
