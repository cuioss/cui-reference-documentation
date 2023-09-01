package de.cuioss.portal.reference.portal.navigation.items.portal;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the "i18n, Message Bundle and Message Producer" menu-item.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class I18nMessagesMenuItem extends PortalBaseMenuItem {

    private static final long serialVersionUID = -283980253229892078L;

    /** The label Key for this component. */
    public static final String LABEL_VALUE = "i18n, Message Bundle and Message Producer";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-global";

    /** The icon for this item. */
    public static final String OUTCOME = "/faces/pages/documentation/portal/core/i18n_message_bundle.xhtml";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "portali18nMBHandling";

    /**
     * Constructor.
     *
     * @param order
     */
    public I18nMessagesMenuItem(int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelValue(LABEL_VALUE);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
