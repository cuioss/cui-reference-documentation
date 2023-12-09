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
public class BasicConceptsMenuItem extends PortalBaseMenuItem {

    private static final long serialVersionUID = -283980253229892078L;

    /** The label Key for this component. */
    public static final String LABEL_VALUE = "Basic Concepts";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-shirt";

    /** The icon for this item. */
    public static final String OUTCOME = "/documentation/portal/core/basic_concepts.xhtml";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "portalBasicConcepts";

    /**
     * Constructor.
     *
     * @param order
     */
    public BasicConceptsMenuItem(int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelValue(LABEL_VALUE);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
