package de.cuioss.portal.reference.portal.navigation.items;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItem;
import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemContainerImpl;
import de.cuioss.portal.common.cdi.PortalBeanManager;
import de.cuioss.portal.configuration.PortalConfigurationKeys;
import de.cuioss.portal.ui.api.menu.PortalMenuItem;
import de.cuioss.portal.ui.api.menu.items.AboutMenuItem;
import de.cuioss.portal.ui.api.menu.items.AccountMenuItem;
import de.cuioss.portal.ui.api.menu.items.PreferencesMenuItem;
import de.cuioss.tools.collect.CollectionLiterals;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents the Icon top-level menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PagesMenu extends NavigationMenuItemContainerImpl {

    private static final long serialVersionUID = 1452093785009425867L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.pages";

    /** The icon for the user. */
    public static final String ICON = "cui-icon-picture";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "pagesContainer";

    /**
     * Constructor.
     *
     * @param order
     */
    public PagesMenu(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setId(MENU_ID);
        // Create and add the menu children
        List<NavigationMenuItem> children = new ArrayList<>();
        PortalBeanManager.resolveBean(AboutMenuItem.class, PortalMenuItem.class).ifPresent(children::add);
        PortalBeanManager.resolveBean(PreferencesMenuItem.class, PortalMenuItem.class).ifPresent(children::add);
        PortalBeanManager.resolveBean(AccountMenuItem.class, PortalMenuItem.class).ifPresent(children::add);
        Collections.sort(children);
        super.setChildren(CollectionLiterals.immutableList(children));
    }

    @Override
    public String getParentId() {
        return PortalConfigurationKeys.MENU_TOP_IDENTIFIER;
    }
}
