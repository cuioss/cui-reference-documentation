package de.cuioss.portal.reference.portal.navigation.items.cui;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the CUI Converter menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CuiConverterMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = -8355845325661800964L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.cui.taglib.converter";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-arrow_e_w";

    /** The icon for this item. */
    public static final String OUTCOME = "cui_converter";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiConverterMenuItem";

    /**
     * @param order
     */
    public CuiConverterMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
