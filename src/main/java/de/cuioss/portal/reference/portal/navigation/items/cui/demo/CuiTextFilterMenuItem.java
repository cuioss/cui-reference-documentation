package de.cuioss.portal.reference.portal.navigation.items.cui.demo;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * Represents the Cui-TextFilter menu.
 *
 * @author Matthias Walliczek
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CuiTextFilterMenuItem extends NavigationMenuItemSingleImpl {

    @Serial
    private static final long serialVersionUID = -8355845325661800964L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.cui.components.demo.text_filter";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-search";

    /** The outcome for this item. */
    public static final String OUTCOME = "cui_text_filter";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiTextFilterMenuItem";

    /**
     * @param order
     */
    public CuiTextFilterMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
