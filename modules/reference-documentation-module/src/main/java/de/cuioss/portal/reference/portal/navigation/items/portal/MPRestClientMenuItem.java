package de.cuioss.portal.reference.portal.navigation.items.portal;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the "MP Rest Client" menu-item.
 *
 * @author Matthias Walliczek
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MPRestClientMenuItem extends PortalBaseMenuItem {

    private static final long serialVersionUID = -283980253229892078L;

    /**
     * The label Key for this component.
     */
    public static final String LABEL_VALUE = "MP Rest Client";

    /**
     * The icon for this item.
     */
    public static final String ICON = "cui-icon-log_book";

    /**
     * The icon for this item.
     */
    public static final String OUTCOME = "/documentation/portal/clients/mp_rest_client.xhtml";

    /**
     * The string based id for this menu item.
     */
    public static final String MENU_ID = "portalMpRestClient";

    /**
     * Constructor.
     *
     * @param order
     */
    public MPRestClientMenuItem(int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelValue(LABEL_VALUE);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
