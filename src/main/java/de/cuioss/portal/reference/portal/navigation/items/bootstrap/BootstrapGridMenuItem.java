package de.cuioss.portal.reference.portal.navigation.items.bootstrap;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * Represents the bootstrap-grid menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BootstrapGridMenuItem extends NavigationMenuItemSingleImpl {

    @Serial
    private static final long serialVersionUID = -5972678239435482932L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.bootstrap.grid";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-vector_path_all";

    /** The icon for this item. */
    public static final String OUTCOME = "bootstrap_grid_demo";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "bootstrapGridMenuItem";

    /**
     * Constructor.
     *
     * @param order
     */
    public BootstrapGridMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
