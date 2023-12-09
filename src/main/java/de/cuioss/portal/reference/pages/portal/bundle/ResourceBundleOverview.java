package de.cuioss.portal.reference.pages.portal.bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.Application;
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

    private static final long serialVersionUID = 3479991887955291155L;

    @Getter
    private List<BundleDescripor> descripors;

    @Inject
    Application application;

    @Inject
    ResourceBundleRegistry bundleRegistry;

    /**
     * reads the configured {@link ResourceBundle}s
     */
    @PostConstruct
    public void init() {
        descripors = new ArrayList<>();
        for (ResourceBundleLocator locator : bundleRegistry.getResolvedPaths()) {
            descripors.add(new BundleDescripor(locator.getBundlePath().orElse("unknown"),
                    locator.getBundle(Locale.getDefault()).orElse(null)));
        }
    }
}
