package de.cuioss.portal.reference.portal.navigation.items.cui.demo;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * Represents the Cui-LazyLoading menu.
 *
 * @author Matthias Walliczek
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CuiLazyLoadingMenuItem extends NavigationMenuItemSingleImpl {

    @Serial
    private static final long serialVersionUID = -8355845325661800964L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.cui.components.demo.lazy_loading";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-refresh";

    /** The outcome for this item. */
    public static final String OUTCOME = "cui_lazy_loading";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiLazyLoadingMenuItem";

    /**
     * @param order
     */
    public CuiLazyLoadingMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
