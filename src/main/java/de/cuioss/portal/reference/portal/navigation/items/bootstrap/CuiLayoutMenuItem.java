package de.cuioss.portal.reference.portal.navigation.items.bootstrap;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the Cui-Validator menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CuiLayoutMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = -1017132222838969928L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.cui.components.demo.layout";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-align_center";

    /** The icon for this item. */
    public static final String OUTCOME = "cui_layout";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiLayoutMenuItem";

    /**
     * Constructor.
     *
     * @param order
     */
    public CuiLayoutMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
