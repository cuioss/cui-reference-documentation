package de.cuioss.portal.reference.portal.navigation;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItem;
import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemContainer;
import de.cuioss.portal.common.priority.PortalPriorities;
import de.cuioss.portal.reference.portal.navigation.items.*;
import de.cuioss.portal.reference.portal.navigation.items.portal.PortalCoreMenuItem;
import de.cuioss.portal.ui.api.menu.NavigationMenuProvider;
import de.cuioss.tools.collect.CollectionBuilder;
import de.cuioss.tools.collect.CollectionLiterals;
import de.cuioss.tools.string.MoreStrings;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Alternative;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * The references create its own menu
 *
 * @author Oliver Wolff
 */
@Alternative
@Priority(PortalPriorities.PORTAL_MODULE_LEVEL)
@SessionScoped
@EqualsAndHashCode
@ToString
public class ReferenceMenuProvider implements NavigationMenuProvider {

    @Serial
    private static final long serialVersionUID = 8780699386708876208L;

    @Getter
    private List<NavigationMenuItem> navigationMenuItems = Collections.emptyList();

    @Getter
    private List<NavigationMenuItem> portalCoreMenuItems;

    /**
     * Initializes the model for the navigation menu.
     */
    @PostConstruct
    public void initBean() {
        List<NavigationMenuItem> children = new ArrayList<>();
        children.add(new GettingStartedMenu(10));
        children.add(new PortalMenu(20));
        children.add(new CuiComponentsMenu(30));
        children.add(new ExternalComponentsMenu(40));
        children.add(new IconMenu(50));
        children.add(new PagesMenu(60));
        Collections.sort(children);
        navigationMenuItems = CollectionLiterals.immutableList(children);

        portalCoreMenuItems = new PortalCoreMenuItem().getChildren();
    }

    @Override
    public boolean isDisplayNavigationMenu() {
        return true;
    }

    @Override
    public List<NavigationMenuItem> getNavigationMenuRoots() {
        return navigationMenuItems;
    }

    @Override
    public Optional<NavigationMenuItem> getMenuItemById(String id) {
        if (MoreStrings.isEmpty(id)) {
            return Optional.empty();
        }
        return navigationMenuItems.stream().filter(item -> id.equalsIgnoreCase(item.getId())).findFirst();
    }

    @Override
    public List<NavigationMenuItem> getMenuItemsByParentId(String parentId) {
        return Collections.emptyList();
    }

    @Override
    public List<NavigationMenuItem> getMenuItemsByIds(String... ids) {
        if (null == ids || ids.length == 0) {
            return Collections.emptyList();
        }
        var builder = new CollectionBuilder<NavigationMenuItem>();
        for (String id : ids) {
            builder.add(getMenuItemById(id));
        }
        return builder.toImmutableList();
    }

    @Override
    public Optional<NavigationMenuItemContainer> getContainerMenuItemById(String id) {
        var item = getMenuItemById(id);
        if (item.isEmpty() || !(item.get() instanceof NavigationMenuItemContainer)) {
            return Optional.empty();
        }
        return Optional.of((NavigationMenuItemContainer) item.get());
    }
}
