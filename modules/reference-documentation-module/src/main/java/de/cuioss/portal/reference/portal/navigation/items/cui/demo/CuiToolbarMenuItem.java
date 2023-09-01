package de.cuioss.portal.reference.portal.navigation.items.cui.demo;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the Cui-Toolbar menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CuiToolbarMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = 16094524036295055L;

    /** The label value for this component. */
    public static final String LABEL_VALUE = "Toolbar";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-grip_solid_horizontal";

    /** The outcome for this item. */
    public static final String OUTCOME = "/faces/pages/documentation/cui_components/demo/toolbar.xhtml";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiToolbarMenuItem";

    /**
     * @param order
     */
    public CuiToolbarMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelValue(LABEL_VALUE);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
