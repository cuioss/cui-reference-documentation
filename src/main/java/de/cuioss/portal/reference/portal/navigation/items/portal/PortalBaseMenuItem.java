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

import de.cuioss.jsf.api.application.navigation.NavigationUtils;
import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import jakarta.faces.context.FacesContext;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * Base class for Portal-menue-Items The assumption is, that
 * {@link #getOutcome()} represents a view (implicit navigation). If so the
 * {@link #isActive()} uses this information, to determine whether the current
 * view is active.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
public class PortalBaseMenuItem extends NavigationMenuItemSingleImpl {

    @Serial
    private static final long serialVersionUID = -4707337520204816491L;

    public PortalBaseMenuItem(Integer order) {
        super(order);
    }

    @Override
    public boolean isActive() {
        return NavigationUtils.getCurrentView(FacesContext.getCurrentInstance()).getViewId().contains(getOutcome());
    }
}
