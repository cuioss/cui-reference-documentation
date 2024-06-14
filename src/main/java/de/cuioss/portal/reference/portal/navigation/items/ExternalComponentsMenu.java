package de.cuioss.portal.reference.portal.navigation.items;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItem;
import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemContainerImpl;
import de.cuioss.portal.configuration.PortalConfigurationKeys;
import de.cuioss.portal.reference.portal.navigation.items.external.JSFCoreMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.external.JSFHtmlMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.external.OmnifacesMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.external.PrimefacesMenuItem;
import de.cuioss.tools.collect.CollectionLiterals;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents the Cui-Components top-level menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExternalComponentsMenu extends NavigationMenuItemContainerImpl {

    @Serial
    private static final long serialVersionUID = -8071397946025081002L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.external.taglib.label";

    /** The icon for the user. */
    public static final String ICON = "cui-icon-anchor";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "externalComponentsMenu";

    /**
     * Constructor.
     *
     * @param order
     */
    public ExternalComponentsMenu(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setId(MENU_ID);
        // Create and add the menu children
        List<NavigationMenuItem> children = new ArrayList<>();
        children.add(new JSFCoreMenuItem());
        children.add(new JSFHtmlMenuItem());
        children.add(new OmnifacesMenuItem());
        children.add(new PrimefacesMenuItem());
        Collections.sort(children);
        super.setChildren(CollectionLiterals.immutableList(children));
    }

    @Override
    public String getParentId() {
        return PortalConfigurationKeys.MENU_TOP_IDENTIFIER;
    }
}
