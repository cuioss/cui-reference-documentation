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
public class CuiLabeledContainerMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = -8355845325661800964L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.cui.components.demo.labeled.container";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-edit";

    /** The icon for this item. */
    public static final String OUTCOME = "cui_labeled_container";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiLabeledContainerMenuItem";

    /**
     * Constructor.
     *
     * @param order
     */
    public CuiLabeledContainerMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
