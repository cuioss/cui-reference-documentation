package de.cuioss.portal.reference.portal.navigation.items.icon;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the Cui-icon menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PrimeFacesCuiIconMappingMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = -8355845325661800964L;

    private static final Integer ORDER = 20;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.cui.icon.to.prime";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-random";

    /** The icon for this item. */
    public static final String OUTCOME = "primefaces_icon_mapping";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "primeFacesCuiIconMappingMenuItem";

    /**
     * Constructor.
     */
    public PrimeFacesCuiIconMappingMenuItem() {
        super(ORDER);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
