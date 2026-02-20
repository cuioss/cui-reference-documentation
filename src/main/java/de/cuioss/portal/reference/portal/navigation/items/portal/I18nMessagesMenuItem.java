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

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * Represents the "i18n, Message Bundle and Message Producer" menu-item.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class I18nMessagesMenuItem extends PortalBaseMenuItem {

    @Serial
    private static final long serialVersionUID = -283980253229892078L;

    /** The label Key for this component. */
    public static final String LABEL_VALUE = "i18n, Message Bundle and Message Producer";

    /** The icon for this item. */
    public static final String ICON = "cui-icon-global";

    /** The icon for this item. */
    public static final String OUTCOME = "/documentation/portal/core/i18n_message_bundle.xhtml";

    /** The string based id for this menu item. */
    public static final String MENU_ID = "portali18nMBHandling";

    /**
     * Constructor.
     *
     * @param order
     */
    public I18nMessagesMenuItem(int order) {
        super(order);
        super.setIconStyleClass(ICON);
        super.setLabelValue(LABEL_VALUE);
        super.setOutcome(OUTCOME);
        super.setId(MENU_ID);
    }
}
