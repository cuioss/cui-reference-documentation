package de.cuioss.portal.reference.portal.navigation.items.icon;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the Cui-icon menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IconComponentsMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = -8355845325661800964L;

    private static final Integer ORDER = 10;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.cui.icon.components";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-claw_hammer";

    /** The icon for this item. */
    public static final String OUTCOME = "cui_icon_components";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiIconComponentsMenuItem";

    /**
     * Constructor.
     */
    public IconComponentsMenuItem() {
        super(ORDER);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
