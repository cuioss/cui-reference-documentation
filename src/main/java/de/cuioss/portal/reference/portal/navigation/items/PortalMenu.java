package de.cuioss.portal.reference.portal.navigation.items;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItem;
import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemContainerImpl;
import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSeparatorImpl;
import de.cuioss.portal.configuration.PortalConfigurationKeys;
import de.cuioss.portal.reference.portal.navigation.items.portal.*;
import de.cuioss.tools.collect.CollectionLiterals;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Portal top-level menu.
 *
 * @author Oliver Wolff, Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PortalMenu extends NavigationMenuItemContainerImpl {

    private static final long serialVersionUID = 1452093785009425867L;

    /**
     * The label Key for this component.
     */
    public static final String LABEL_KEY = "navigation.menue.portal";

    /**
     * The icon for the user.
     */
    public static final String ICON = "cui-icon-kiosk";

    /**
     * The string-based id for this menu item.
     */
    public static final String MENU_ID = "portalContainer";

    /**
     * Constructor.
     *
     * @param order
     */
    public PortalMenu(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setId(MENU_ID);

        var i = 0;

        // Create and add the menu children
        List<NavigationMenuItem> children = new ArrayList<>();
        children.add(new ArchitectureMenuItem(i));
        i++;
        children.add(new BasicConceptsMenuItem(i));
        i++;
        children.add(new CommonObjectsMenuItem(i));
        i++;
        children.add(new LocaleHandlingMenuItem(i));
        i++;
        children.add(new I18nMessagesMenuItem(i++));
        children.add(new PortalResourceBundlesMenuItem(i++));
        children.add(new NavigationMenuItemSeparatorImpl(i++));
        children.add(new PortalTemplatesMenuItem(i++));
        children.add(new ConnectionMetadataMenuItem(i++));
        children.add(new ErrorHandlingMenuItem(i++));
        super.setChildren(CollectionLiterals.immutableList(children));
    }

    @Override
    public String getParentId() {
        return PortalConfigurationKeys.MENU_TOP_IDENTIFIER;
    }
}
