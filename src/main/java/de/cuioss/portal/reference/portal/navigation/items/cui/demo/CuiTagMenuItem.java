package de.cuioss.portal.reference.portal.navigation.items.cui.demo;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the Cui-Tag menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CuiTagMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = -8355845325661800964L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.cui.components.demo.tag";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-tag";

    /** The icon for this item. */
    public static final String OUTCOME = "cui_tag";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiTagMenuItem";

    /**
     * @param order
     */
    public CuiTagMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
