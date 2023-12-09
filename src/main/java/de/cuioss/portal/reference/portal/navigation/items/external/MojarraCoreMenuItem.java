package de.cuioss.portal.reference.portal.navigation.items.external;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the mojarra-core menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MojarraCoreMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = -2631323736244851020L;

    private static final Integer ORDER = 40;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.external.mojarra.core.label";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-brightness_reduce";

    /** The icon for this item. */
    public static final String OUTCOME = "external_mojarra_core";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "mojarraCoreMenuItem";

    /**
     * Constructor.
     */
    public MojarraCoreMenuItem() {
        super(ORDER);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
