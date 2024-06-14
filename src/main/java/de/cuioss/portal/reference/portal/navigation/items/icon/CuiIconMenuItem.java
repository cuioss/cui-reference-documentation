package de.cuioss.portal.reference.portal.navigation.items.icon;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * Represents the Cui-icon menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CuiIconMenuItem extends NavigationMenuItemSingleImpl {

    @Serial
    private static final long serialVersionUID = -8355845325661800964L;

    private static final Integer ORDER = 20;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.cui.icon";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-playing_dices";

    /** The icon for this item. */
    public static final String OUTCOME = "cui_icons";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiIconMenuItem";

    /**
     * Constructor.
     */
    public CuiIconMenuItem() {
        super(ORDER);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
