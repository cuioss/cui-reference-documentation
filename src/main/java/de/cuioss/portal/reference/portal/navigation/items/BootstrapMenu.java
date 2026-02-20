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
import de.cuioss.portal.reference.portal.navigation.items.bootstrap.BootstrapGridMenuItem;
import de.cuioss.portal.reference.portal.navigation.items.bootstrap.FormMenuItem;
import de.cuioss.tools.collect.CollectionLiterals;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

/**
 * Represents the Twitter Bootstrap menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BootstrapMenu extends NavigationMenuItemContainerImpl {

    @Serial
    private static final long serialVersionUID = 2201988986700729036L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.bootstrap";

    /** The icon for the user. */
    public static final String ICON = "cui-icon-brush";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "bootstrapContainer";

    /**
     * Constructor.
     *
     * @param order
     */
    public BootstrapMenu(final int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setId(MENU_ID);
        // Create and add the menu children
        List<NavigationMenuItem> children = new ArrayList<>();
        children.add(new FormMenuItem(20));
        children.add(new BootstrapGridMenuItem(40));
        sort(children);
        super.setChildren(CollectionLiterals.immutableList(children));
    }
}
