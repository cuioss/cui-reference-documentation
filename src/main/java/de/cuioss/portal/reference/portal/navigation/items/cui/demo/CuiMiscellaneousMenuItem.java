package de.cuioss.portal.reference.portal.navigation.items.cui.demo;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the CUI Misc menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CuiMiscellaneousMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = -8355845325661800964L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.cui.components.demo.miscellaneous";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-magic";

    /** The icon for this item. */
    public static final String OUTCOME = "cui_miscellaneous";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiMiscellaneousMenuItem";

    /**
     * @param order
     */
    public CuiMiscellaneousMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
