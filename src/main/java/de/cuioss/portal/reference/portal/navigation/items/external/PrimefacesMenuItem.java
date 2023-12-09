package de.cuioss.portal.reference.portal.navigation.items.external;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the primefaces menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PrimefacesMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = 7739111728601572369L;

    private static final Integer ORDER = 50;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.external.prime.label";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-snowflake";

    /** The icon for this item. */
    public static final String OUTCOME = "external_primefaces";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "primeFacesMenuItem";

    /**
     * Constructor.
     */
    public PrimefacesMenuItem() {
        super(ORDER);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
