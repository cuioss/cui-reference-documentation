package de.cuioss.portal.reference.portal.navigation.items.cui.demo;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * Represents the Cui-EditableDataList menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CuiEditableDatalistMenuItem extends NavigationMenuItemSingleImpl {

    @Serial
    private static final long serialVersionUID = -8355845325661800964L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.cui.components.demo.editable_data_list";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-justify";

    /** The outcome for this item. */
    public static final String OUTCOME = "cui_editable_data_list";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiEditableDatalistMenuItem";

    /**
     * @param order
     */
    public CuiEditableDatalistMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
