/*
 * Copyright © 2025 CUI-OpenSource-Software (info@cuioss.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.cuioss.portal.reference.portal.navigation.items;

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

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents the Icon top-level menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IconMenu extends NavigationMenuItemContainerImpl {

    @Serial
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
