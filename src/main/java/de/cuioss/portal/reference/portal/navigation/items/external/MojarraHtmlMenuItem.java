package de.cuioss.portal.reference.portal.navigation.items.external;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the mojarra-html menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MojarraHtmlMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = 7187954186034012526L;

    private static final Integer ORDER = 20;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.external.mojarra.html.label";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-brightness_increase";

    /** The icon for this item. */
    public static final String OUTCOME = "external_mojarra_html";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "mojarraFacesMenuItem";

    /**
     * Constructor.
     */
    public MojarraHtmlMenuItem() {
        super(ORDER);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
