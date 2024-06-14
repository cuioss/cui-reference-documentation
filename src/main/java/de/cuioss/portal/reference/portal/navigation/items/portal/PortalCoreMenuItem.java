package de.cuioss.portal.reference.portal.navigation.items.portal;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItem;
import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemContainerImpl;
import de.cuioss.tools.collect.CollectionLiterals;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Portal Core Module menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PortalCoreMenuItem extends NavigationMenuItemContainerImpl {

    @Serial
    private static final long serialVersionUID = -283980253229892078L;

    private static final Integer ORDER = 25;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.portal.core_module";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-coins";

    /** The icon for this item. */
    public static final String OUTCOME = "portal_core_module";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "portalCoreModule";

    /**
     * Constructor.
     */
    public PortalCoreMenuItem() {
        super(ORDER);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setId(MENU_ID);

        var i = 0;

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

        super.setChildren(CollectionLiterals.immutableList(children));
    }
}
