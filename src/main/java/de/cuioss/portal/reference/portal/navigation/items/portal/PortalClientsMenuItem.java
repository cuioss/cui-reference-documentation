package de.cuioss.portal.reference.portal.navigation.items.portal;

import java.util.ArrayList;
import java.util.List;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItem;
import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemContainerImpl;
import de.cuioss.tools.collect.CollectionLiterals;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the Portal Core Module menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PortalClientsMenuItem extends NavigationMenuItemContainerImpl {

    private static final long serialVersionUID = -283980253229892078L;

    private static final Integer ORDER = 25;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.portal.clients_module";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-coins";

    /** The icon for this item. */
    public static final String OUTCOME = "portal_clients_module";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "portalClientsModule";

    /**
     * Constructor.
     */
    public PortalClientsMenuItem() {
        super(ORDER);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setId(MENU_ID);

        var i = 0;

        List<NavigationMenuItem> children = new ArrayList<>();
        children.add(new MPRestClientMenuItem(i));
        i++;

        super.setChildren(CollectionLiterals.immutableList(children));
    }
}
