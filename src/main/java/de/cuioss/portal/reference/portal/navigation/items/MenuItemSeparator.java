package de.cuioss.portal.reference.portal.navigation.items;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSeparatorImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the Cui-Components-Demo menu.
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MenuItemSeparator extends NavigationMenuItemSeparatorImpl {

    private static final long serialVersionUID = -8355845325661800964L;

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiComponentsDemoMenuItem";

    /**
     * Constructor.
     *
     * @param orderNumber int value
     */
    public MenuItemSeparator(final int orderNumber) {
        super(orderNumber);
        super.setId(MENU_ID.concat(String.valueOf(orderNumber)));
    }
}
