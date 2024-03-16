package de.cuioss.portal.reference.pages.portal.bundle;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.cuioss.portal.common.bundle.ResourceBundleLocator;
import de.cuioss.portal.common.bundle.ResourceBundleRegistry;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

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
