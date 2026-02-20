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
package de.cuioss.portal.reference.pages.components.demo;

import de.cuioss.jsf.api.ui.model.ToggleSwitch;
import de.cuioss.tools.logging.CuiLogger;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Data provider for the panel demo page
 *
 * @author Sven Haag
 */
@Named
@SessionScoped
@EqualsAndHashCode
@ToString
public class PanelDemoProvider implements Serializable {

    private static final CuiLogger LOGGER = new CuiLogger(PanelDemoProvider.class);

    @Serial
    private static final long serialVersionUID = 260766844925472554L;

    @Getter
    @Setter
    private ToggleSwitch toggleSwitch = new ToggleSwitch(Boolean.FALSE);

    @Getter
    @Setter
    private boolean bool = true;

    /**
     * @return test data with delay
     */
    public String getData() {
        LOGGER.debug("Delayed data request started. waiting some time...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // cui-rewrite:disable CuiLogRecordPatternRecipe
            LOGGER.error(e, "Delayed data delivery interrupted");
            Thread.currentThread().interrupt();
        }
        LOGGER.debug("Delivering delayed data.");
        return "Delayed data, called at: " + LocalDateTime.now().format(DateTimeFormatter.ISO_TIME);
    }
}
