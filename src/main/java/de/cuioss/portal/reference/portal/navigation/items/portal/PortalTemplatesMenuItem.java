package de.cuioss.portal.reference.portal.navigation.items.portal;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * Represents the Portal Templates menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PortalTemplatesMenuItem extends NavigationMenuItemSingleImpl {

    @Serial
    private static final long serialVersionUID = -283980253229892078L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.portal.templates";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-list";

    /** The icon for this item. */
    public static final String OUTCOME = "portal_templates";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "portalTemplates";

    /**
     * Constructor.
     *
     * @param order
     */
    public PortalTemplatesMenuItem(int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
