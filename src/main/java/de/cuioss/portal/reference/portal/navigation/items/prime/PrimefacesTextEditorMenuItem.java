package de.cuioss.portal.reference.portal.navigation.items.prime;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the primefaces tree menu.
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PrimefacesTextEditorMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = -5972678239435482932L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.primefaces.textEditor";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-pencil";

    /** The icon for this item. */
    public static final String OUTCOME = "prime_textEditor_demo";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "primefacesTextEditorMenuItem";

    /**
     * Constructor.
     *
     * @param order
     */
    public PrimefacesTextEditorMenuItem(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
