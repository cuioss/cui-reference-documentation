/*
 * Copyright © 2025 CUI-OpenSource-Software (info@cuioss.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.cuioss.portal.reference.portal.application;

import de.cuioss.portal.common.bundle.ResourceBundleLocator;
import de.cuioss.portal.common.priority.PortalPriorities;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Defines the additional bundle
 *
 * @author Oliver Wolff
 */
@ApplicationScoped
@Priority(PortalPriorities.PORTAL_MODULE_LEVEL)
@EqualsAndHashCode
public class ReferenceBundle implements ResourceBundleLocator {
    @Serial
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
            // cui-rewrite:disable CuiLogRecordPatternRecipe
            LOGGER.warn(e, "Unable to load %s '%s' for '%s'".formatted(getClass().getName(), PATH, locale));
            return Optional.empty();
        }
    }

}
