package de.cuioss.portal.reference.portal.navigation.items.prime;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * Represents the primefaces wizard menu.
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PrimefacesWizardMenuItem extends NavigationMenuItemSingleImpl {

    @Serial
    private static final long serialVersionUID = -5972678239435482932L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.primefaces.wizard";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-triangle_e_w";

    /** The icon for this item. */
    public static final String OUTCOME = "prime_wizard_demo";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "primefacesWizardMenuItem";

    /**
     * @param order
     */
    public PrimefacesWizardMenuItem(final Integer order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
