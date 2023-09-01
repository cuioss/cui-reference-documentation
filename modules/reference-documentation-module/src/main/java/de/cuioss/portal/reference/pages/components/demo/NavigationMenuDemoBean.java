package de.cuioss.portal.reference.pages.components.demo;

import static de.cuioss.tools.collect.CollectionLiterals.immutableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import de.cuioss.jsf.api.application.navigation.NavigationUtils;
import de.cuioss.jsf.api.components.model.menu.NavigationMenuItem;
import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemContainerImpl;
import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import de.cuioss.portal.ui.api.menu.PortalMenuItem;
import de.cuioss.portal.ui.api.menu.items.AccountMenuItem;
import de.cuioss.portal.ui.api.menu.items.LogoutMenuItem;
import de.cuioss.portal.ui.api.menu.items.UserMenuItem;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Portal demo navigation menu with nested sub menu.
 *
 * @author Sven Haag
 */
@Named
@SessionScoped
@EqualsAndHashCode
@ToString
public class NavigationMenuDemoBean implements Serializable {

    private static final long serialVersionUID = -4202668219654666745L;

    private static final String MENU_ITEM_ID = "demoMenuId";

    private static final String MENU_ITEM_ICON = "cui-icon-star";

    private static final String MENU_ITEM_LABEL = "Demo Menu Item";

    @Getter
    private final List<NavigationMenuItem> navItems = new ArrayList<>();

    /**
     * Initialize the {@link NavigationMenuItem}s
     */
    @PostConstruct
    public void init() {
        navItems.add(getNavDemoItem());
    }

    @Inject
    @PortalMenuItem
    AccountMenuItem accountMenu;

    @Inject
    @PortalMenuItem
    UserMenuItem userMenu;

    @Inject
    @PortalMenuItem
    LogoutMenuItem logout;

    /**
     * @return NavigationMenuItem
     */
    public NavigationMenuItem getNavDemoItem() {
        final var container = new NavigationMenuItemContainerImpl(25);
        container.setTitleValue(MENU_ITEM_LABEL);
        container.setLabelValue(MENU_ITEM_LABEL);
        container.setId(MENU_ITEM_ID);
        container.setIconStyleClass(MENU_ITEM_ICON);
        container.setActiveForAdditionalViewId(
                immutableList(NavigationUtils.getCurrentView(FacesContext.getCurrentInstance()).getViewId()));

        List<NavigationMenuItem> subMenues = new ArrayList<>();

        subMenues.add(accountMenu);

        subMenues.add(userMenu);

        final var child1 = new NavigationMenuItemContainerImpl(1);
        child1.setId("child1");
        child1.setLabelValue("child1labelValue");

        final var child2 = new NavigationMenuItemContainerImpl(2);
        child2.setId("child2");
        child2.setDisabled(true);
        child2.setLabelValue("child2labelValue");

        final var child3 = new NavigationMenuItemContainerImpl(3);
        child3.setId("child3");
        child3.setLabelValue("child3labelValue");

        final var child4 = new NavigationMenuItemSingleImpl(4);
        child4.setId("child4");
        child4.setLabelValue("child4labelValue");
        child4.getOutcomeParameter().put("param1", "value1");

        userMenu.getChildren().add(child1);
        child1.getChildren().add(child2);
        child2.getChildren().add(child3);
        child3.getChildren().add(child4);

        subMenues.add(logout);

        container.setChildren(subMenues);

        return container;
    }
}
