package de.cuioss.portal.reference.portal.navigation.items.cui.demo;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the CUI Fieldset Components menu.
 *
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CuiFieldsetMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = 1452093785009425867L;

    /** The label Key for this component. */
    public static final String LABEL_VALUE = "Fieldset";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-justify";

    /** The outcome for this item. */
    public static final String OUTCOME = "/pages/documentation/cui_components/demo/fieldset.xhtml";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiFieldsetMenuItem";

    /**
     * @param order
     */
    public CuiFieldsetMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelValue(LABEL_VALUE);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
