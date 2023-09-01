package de.cuioss.portal.reference.portal.navigation.items.external;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the omnifaces menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OmnifacesMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = -6144561213356288526L;

    private static final Integer ORDER = 60;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.external.omni.label";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-global";

    /** The icon for this item. */
    public static final String OUTCOME = "external_omnifaces";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "omniFacesMenuItem";

    /**
     * Constructor.
     */
    public OmnifacesMenuItem() {
        super(ORDER);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
