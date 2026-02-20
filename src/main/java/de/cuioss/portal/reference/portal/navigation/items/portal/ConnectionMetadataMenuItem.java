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
 * Represents the "Connection Metadata" menu-item.
 *
 * @author Sven Haag
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ConnectionMetadataMenuItem extends PortalBaseMenuItem {

    @Serial
    private static final long serialVersionUID = 4023392122979460944L;

    /** The string based id for this menu item. */
    public static final String MENU_ID = "portalConnectionMetadata";

    /**
     * Constructor.
     *
     * @param order
     */
    public ConnectionMetadataMenuItem(int order) {
        super(order);
        super.setIconStyleClass("cui-icon-wifi"); // share_alt, conversation
        super.setLabelValue("Connection Metadata");
        super.setOutcome("/documentation/portal/core/connection_metadata.xhtml");
        super.setId(MENU_ID);
    }
}
