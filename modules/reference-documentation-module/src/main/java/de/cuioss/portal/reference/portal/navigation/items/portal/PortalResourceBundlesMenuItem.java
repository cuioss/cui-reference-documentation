package de.cuioss.portal.reference.portal.navigation.items.portal;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the "Standard ResourceBundles" menu-item.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PortalResourceBundlesMenuItem extends PortalBaseMenuItem {

    private static final long serialVersionUID = -283980253229892078L;

    /** The label Key for this component. */
    public static final String LABEL_VALUE = "Standard ResourceBundles";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-book";

    /** The icon for this item. */
    public static final String OUTCOME = "/faces/pages/documentation/portal/core/portal_resource_bundles.xhtml";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "portali18nMBHandling";

    /**
     * Constructor.
     *
     * @param order
     */
    public PortalResourceBundlesMenuItem(int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelValue(LABEL_VALUE);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
