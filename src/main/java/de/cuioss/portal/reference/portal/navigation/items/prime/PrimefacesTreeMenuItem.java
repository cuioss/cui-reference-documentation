package de.cuioss.portal.reference.portal.navigation.items.prime;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * Represents the primefaces tree menu.
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PrimefacesTreeMenuItem extends NavigationMenuItemSingleImpl {

    @Serial
    private static final long serialVersionUID = -5972678239435482932L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.primefaces.tree";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-tree_conifer";

    /** The icon for this item. */
    public static final String OUTCOME = "prime_tree_demo";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "primefacesTreeMenuItem";

    /**
     * Constructor.
     *
     * @param order
     */
    public PrimefacesTreeMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
