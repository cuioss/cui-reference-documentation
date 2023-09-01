package de.cuioss.portal.reference.portal.navigation.items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItem;
import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemContainerImpl;
import de.cuioss.portal.configuration.PortalConfigurationKeys;
import de.cuioss.portal.reference.portal.navigation.items.icon.CuiIconMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.icon.IconComponentsMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.icon.MimeTypeIconMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.icon.PrimeFacesCuiIconMappingMenuItem;
import de.cuioss.tools.collect.CollectionLiterals;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the Icon top-level menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IconMenu extends NavigationMenuItemContainerImpl {

    private static final long serialVersionUID = 1452093785009425867L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.icon";

    /** The icon for the user. */
    public static final String ICON = "cui-icon-picture";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "iconContainer";

    /**
     * Constructor.
     *
     * @param order
     */
    public IconMenu(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setId(MENU_ID);
        // Create and add the menu children
        List<NavigationMenuItem> children = new ArrayList<>();
        children.add(new IconComponentsMenuItem());
        children.add(new CuiIconMenuItem());
        children.add(new MimeTypeIconMenuItem());
        children.add(new PrimeFacesCuiIconMappingMenuItem());
        Collections.sort(children);
        super.setChildren(CollectionLiterals.immutableList(children));
    }

    @Override
    public String getParentId() {
        return PortalConfigurationKeys.MENU_TOP_IDENTIFIER;
    }
}
