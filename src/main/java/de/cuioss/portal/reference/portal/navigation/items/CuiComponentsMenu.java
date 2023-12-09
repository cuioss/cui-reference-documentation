package de.cuioss.portal.reference.portal.navigation.items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItem;
import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemContainerImpl;
import de.cuioss.portal.configuration.PortalConfigurationKeys;
import de.cuioss.portal.reference.portal.navigation.items.bootstrap.CuiLabeledContainerMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.bootstrap.CuiLayoutMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.CuiBehaviorMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.CuiConverterMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.CuiUiComponentsMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.CuiValidatorMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.demo.CuiButtonsMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.demo.CuiCommandButtonsMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.demo.CuiDashboardMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.demo.CuiEditableDatalistMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.demo.CuiFieldsetMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.demo.CuiInputGuardedMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.demo.CuiLazyLoadingMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.demo.CuiMiscellaneousMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.demo.CuiPanelMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.demo.CuiTagMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.demo.CuiTextFilterMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.demo.CuiToolbarMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.demo.DisplayNameProviderMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.demo.JqPlotMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.cui.demo.ModalDialogDemoMenuItem;
import de.cuioss.tools.collect.CollectionLiterals;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the Cui-Components top-level menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CuiComponentsMenu extends NavigationMenuItemContainerImpl {

    private static final long serialVersionUID = 1452093785009425867L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.cui.taglib.label";

    /** The icon for the user. */
    public static final String ICON = "cui-icon-tag";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiComponentsMenu";

    /**
     * Constructor.
     *
     * @param order
     */
    public CuiComponentsMenu(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setId(MENU_ID);

        var i = 0;

        // Create and add the menu children
        final List<NavigationMenuItem> children = new ArrayList<>();
        children.add(new CuiUiComponentsMenuItem(i));
        i++;
        children.add(new CuiValidatorMenuItem(i));
        i++;
        children.add(new CuiConverterMenuItem(i));
        i++;
        children.add(new CuiBehaviorMenuItem(i));
        i++;
        children.add(new DisplayNameProviderMenuItem(i++));

        children.add(new MenuItemSeparator(i++));
        children.add(new BootstrapMenu(i++));
        children.add(new PrimefacesMenu(i++));
        children.add(new MenuItemSeparator(i++));

        children.add(new CuiCommandButtonsMenuItem(i++));
        children.add(new CuiButtonsMenuItem(i++));
        children.add(new CuiEditableDatalistMenuItem(i++));
        children.add(new CuiTextFilterMenuItem(i++));
        children.add(new CuiLazyLoadingMenuItem(i++));
        children.add(new CuiTagMenuItem(i++));
        children.add(new ModalDialogDemoMenuItem(i++));
        children.add(new CuiMiscellaneousMenuItem(i++));
        children.add(new CuiPanelMenuItem(i++));
        children.add(new CuiLabeledContainerMenuItem(i++));
        children.add(new CuiLayoutMenuItem(i++));
        children.add(new CuiFieldsetMenuItem(i++));
        children.add(new CuiToolbarMenuItem(i++));
        children.add(new CuiInputGuardedMenuItem(i++));
        children.add(new JqPlotMenuItem(i++));
        children.add(new CuiDashboardMenuItem(i++));

        Collections.sort(children);
        super.setChildren(CollectionLiterals.immutableList(children));
    }

    @Override
    public String getParentId() {
        return PortalConfigurationKeys.MENU_TOP_IDENTIFIER;
    }
}
