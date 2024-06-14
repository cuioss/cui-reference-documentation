package de.cuioss.portal.reference.portal.navigation.items.cui.demo;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * Represents the GuardedInput menu item.
 *
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CuiInputGuardedMenuItem extends NavigationMenuItemSingleImpl {

    @Serial
    private static final long serialVersionUID = 1524857964753377586L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.cui.components.demo.guardedInput";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-lock";

    /** The outcome for this item. */
    public static final String OUTCOME = "cui_inputGuardedDemo";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiGuardedInputDemoMenuItem";

    /**
     * Constructor.
     *
     * @param order
     */
    public CuiInputGuardedMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
