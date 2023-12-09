package de.cuioss.portal.reference.portal.navigation.items;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import de.cuioss.portal.configuration.PortalConfigurationKeys;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the Icon top-level menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GettingStartedMenu extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = 1452093785009425867L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.getting_started";

    /** The icon for the user. */
    public static final String ICON = "cui-icon-play";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "gettingStarted";

    /** The icon for this item. */
    public static final String OUTCOME = "/documentation/getting_started/index.xhtml";

    /**
     * Constructor.
     *
     * @param order
     */
    public GettingStartedMenu(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setId(MENU_ID);
        super.setOutcome(OUTCOME);
    }

    @Override
    public String getParentId() {
        return PortalConfigurationKeys.MENU_TOP_IDENTIFIER;
    }
}
