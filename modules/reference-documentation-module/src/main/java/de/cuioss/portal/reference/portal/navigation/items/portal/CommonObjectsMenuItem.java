package de.cuioss.portal.reference.portal.navigation.items.portal;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the "Common Objects and Services" menu-item.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommonObjectsMenuItem extends PortalBaseMenuItem {

    private static final long serialVersionUID = -283980253229892078L;

    /** The label Key for this component. */
    public static final String LABEL_VALUE = "Common Objects and Services";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-lightbulb";

    /** The icon for this item. */
    public static final String OUTCOME = "/pages/documentation/portal/core/common_objects.xhtml";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "portalCommonObjects";

    /**
     * Constructor.
     *
     * @param order
     */
    public CommonObjectsMenuItem(int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelValue(LABEL_VALUE);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
