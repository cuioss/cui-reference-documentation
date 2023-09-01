package de.cuioss.portal.reference.pages.portal.bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.Application;
import javax.inject.Inject;
import javax.inject.Named;

import de.cuioss.portal.configuration.bundles.PortalResourceBundleRegistry;
import de.cuioss.portal.configuration.bundles.ResourceBundleRegistry;
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
    @PortalResourceBundleRegistry
    ResourceBundleRegistry bundleRegistry;

    /**
     * reads the configured {@link ResourceBundle}s
     */
    @PostConstruct
    public void init() {
        descripors = new ArrayList<>();
        for (String name : bundleRegistry.getResolvedPaths()) {
            descripors.add(new BundleDescripor(name, ResourceBundle.getBundle(name)));
        }
    }
}
