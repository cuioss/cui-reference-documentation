package de.cuioss.portal.reference.portal.navigation.items.bootstrap;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the form menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FormMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = -5972678239435482932L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.bootstrap.form";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-table";

    /** The icon for this item. */
    public static final String OUTCOME = "bootstrap_form_demo";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "formDemoMenuItem";

    /**
     * Constructor.
     *
     * @param order
     */
    public FormMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
