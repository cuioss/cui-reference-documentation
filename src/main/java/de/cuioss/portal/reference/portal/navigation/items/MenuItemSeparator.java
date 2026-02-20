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

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSeparatorImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * Represents the Cui-Components-Demo menu.
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MenuItemSeparator extends NavigationMenuItemSeparatorImpl {

    @Serial
    private static final long serialVersionUID = -8355845325661800964L;

    /** The string based id for this menu item. */
    public static final String MENU_ID = "cuiComponentsDemoMenuItem";

    /**
     * Constructor.
     *
     * @param orderNumber int value
     */
    public MenuItemSeparator(final int orderNumber) {
        super(orderNumber);
        super.setId(MENU_ID.concat(String.valueOf(orderNumber)));
    }
}
