package de.cuioss.portal.reference.portal.navigation.items.prime;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * Represents the primefaces table menu.
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PrimefacesTableMenuItem extends NavigationMenuItemSingleImpl {

    @Serial
    private static final long serialVersionUID = -5972678239435482932L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.primefaces.table";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-table";

    /** The icon for this item. */
    public static final String OUTCOME = "prime_table_demo";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "primefacesTableMenuItem";

    /**
     * Constructor.
     *
     * @param order
     */
    public PrimefacesTableMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
