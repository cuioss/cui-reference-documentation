package de.cuioss.portal.reference.portal.navigation.items.cui;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * Represents the Cui-Validator menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CuiValidatorMenuItem extends NavigationMenuItemSingleImpl {

    @Serial
    private static final long serialVersionUID = -8355845325661800964L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.cui.taglib.validator";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-circle_ok";

    /** The icon for this item. */
    public static final String OUTCOME = "cui_validator";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiValidatorMenuItem";

    /**
     * @param order
     */
    public CuiValidatorMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
