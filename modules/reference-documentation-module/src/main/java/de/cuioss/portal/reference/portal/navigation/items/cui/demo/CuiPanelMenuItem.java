package de.cuioss.portal.reference.portal.navigation.items.cui.demo;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the CUI Panel Components menu.
 *
 * @author Sven Haag
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CuiPanelMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = 1452093785009425867L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.cui.components.demo.panel";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-nameplate_alt"; // alternatives: cui-icon-sort,
                                                                // cui-icon-show_thumbnails

    /** The icon for this item. */
    public static final String OUTCOME = "cui_panel";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiPanelMenuItem";

    /**
     * @param order
     */
    public CuiPanelMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
