package de.cuioss.portal.reference.portal.navigation.items.cui.demo;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the Cui-Buttons menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CuiButtonsMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = 16094524036295055L;

    /** The label value for this component. */
    public static final String LABEL_VALUE = "Button";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-play";

    /** The outcome for this item. */
    public static final String OUTCOME = "/pages/documentation/cui_components/demo/button.xhtml";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiButtonsMenuItem";

    /**
     * @param order
     */
    public CuiButtonsMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelValue(LABEL_VALUE);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
