package de.cuioss.portal.reference.portal.navigation.items.portal;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the "Connection Metadata" menu-item.
 *
 * @author Sven Haag
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ConnectionMetadataMenuItem extends PortalBaseMenuItem {

    private static final long serialVersionUID = 4023392122979460944L;

    /** The string based id for this menu item. */
    public static final String MENU_ID = "portalConnectionMetadata";

    /**
     * Constructor.
     *
     * @param order
     */
    public ConnectionMetadataMenuItem(int order) {
        super(order);
        super.setIconStyleClass("cui-icon-wifi"); // share_alt, conversation
        super.setLabelValue("Connection Metadata");
        super.setOutcome("/pages/documentation/portal/core/connection_metadata.xhtml");
        super.setId(MENU_ID);
    }
}
