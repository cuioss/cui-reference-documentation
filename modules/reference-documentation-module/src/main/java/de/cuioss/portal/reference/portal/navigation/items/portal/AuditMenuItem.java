package de.cuioss.portal.reference.portal.navigation.items.portal;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the "Basic Concepts" menu-item.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AuditMenuItem extends PortalBaseMenuItem {

    private static final long serialVersionUID = -283980253229892078L;

    /** The label Key for this component. */
    public static final String LABEL_VALUE = "Audit";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-log_book";

    /** The icon for this item. */
    public static final String OUTCOME = "/faces/pages/documentation/portal/core/audit.xhtml";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "portalAudit";

    /**
     * Constructor.
     *
     * @param order
     */
    public AuditMenuItem(int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelValue(LABEL_VALUE);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
