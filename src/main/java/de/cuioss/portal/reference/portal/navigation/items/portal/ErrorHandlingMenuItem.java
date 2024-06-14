package de.cuioss.portal.reference.portal.navigation.items.portal;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * Represents the "Basic Concepts" menu-item.
 *
 * @author Oliver Wolff, Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErrorHandlingMenuItem extends PortalBaseMenuItem {

    @Serial
    private static final long serialVersionUID = -283980253229892078L;

    /** The label Key for this component. */
    public static final String LABEL_VALUE = "Error Handling";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-bomb";

    /** The icon for this item. */
    public static final String OUTCOME = "/documentation/portal/core/error_handling.xhtml";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "portalErrorHandling";

    /**
     * Constructor.
     *
     * @param order
     */
    public ErrorHandlingMenuItem(int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelValue(LABEL_VALUE);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
