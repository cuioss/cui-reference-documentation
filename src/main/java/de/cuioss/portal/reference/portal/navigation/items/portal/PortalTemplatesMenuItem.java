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
package de.cuioss.portal.reference.portal.navigation.items.portal;

import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * Represents the Portal Templates menu.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PortalTemplatesMenuItem extends NavigationMenuItemSingleImpl {

    @Serial
    private static final long serialVersionUID = -283980253229892078L;

    /** The label Key for this component. */
    public static final String LABEL_KEY = "navigation.menue.portal.templates";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-list";

    /** The icon for this item. */
    public static final String OUTCOME = "portal_templates";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "portalTemplates";

    /**
     * Constructor.
     *
     * @param order
     */
    public PortalTemplatesMenuItem(int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelKey(LABEL_KEY);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
