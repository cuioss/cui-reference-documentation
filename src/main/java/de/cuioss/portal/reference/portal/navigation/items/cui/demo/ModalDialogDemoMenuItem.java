package de.cuioss.portal.reference.portal.navigation.items.cui.demo;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the modal-dialog-demo menu.
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ModalDialogDemoMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = -5972678239435482932L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.bootstrap.dialog.demo";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-comments";

    /** The icon for this item. */
    public static final String OUTCOME = "dialog_demo";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "dialogDemoMenuItem";

    /**
     * @param order
     */
    public ModalDialogDemoMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
