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
package de.cuioss.portal.reference.pages.portal.bundle;

import de.cuioss.portal.common.bundle.ResourceBundleLocator;
import de.cuioss.portal.common.bundle.ResourceBundleRegistry;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Oliver Wolff
 *
 */
@Named
@ApplicationScoped
@EqualsAndHashCode
@ToString
public class ResourceBundleOverview implements Serializable {

    @Serial
    private static final long serialVersionUID = 3479991887955291155L;

    @Getter
    private List<BundleDescripor> descriptors;

    @Inject
    ResourceBundleRegistry bundleRegistry;

    /**
     * reads the configured {@link ResourceBundle}s
     */
    @PostConstruct
    public void init() {
        descriptors = new ArrayList<>();
        for (ResourceBundleLocator locator : bundleRegistry.getResolvedPaths()) {
            descriptors.add(new BundleDescripor(locator.getBundlePath().orElse("unknown"),
                locator.getBundle(Locale.getDefault()).orElseThrow(() -> new IllegalStateException("No bundle found for %s".formatted(locator)))));
        }
    }
}
