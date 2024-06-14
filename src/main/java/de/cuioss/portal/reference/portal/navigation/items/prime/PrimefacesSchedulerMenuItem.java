package de.cuioss.portal.reference.portal.navigation.items.prime;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * Represents the primefaces picklist menu.
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PrimefacesSchedulerMenuItem extends NavigationMenuItemSingleImpl {

    @Serial
    private static final long serialVersionUID = -5972678239435482932L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.primefaces.scheduler";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-calendar";

    /** The icon for this item. */
    public static final String OUTCOME = "prime_scheduler_demo";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "primefacesSchedulerMenuItem";

    /**
     * Constructor.
     *
     * @param order
     */
    public PrimefacesSchedulerMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
