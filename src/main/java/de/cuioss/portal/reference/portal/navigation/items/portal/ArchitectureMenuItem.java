package de.cuioss.portal.reference.portal.navigation.items.portal;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the "Architecture And Design" menu-item.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ArchitectureMenuItem extends PortalBaseMenuItem {

    private static final long serialVersionUID = -283980253229892078L;

    /** The label Key for this component. */
    public static final String LABEL_VALUE = "Architecture And Design";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-claw_hammer";

    /** The icon for this item. */
    public static final String OUTCOME = "/documentation/portal/core/architecture_and_design.xhtml";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "portalArchitecture";

    /**
     * Constructor.
     *
     * @param order
     */
    public ArchitectureMenuItem(int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelValue(LABEL_VALUE);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
