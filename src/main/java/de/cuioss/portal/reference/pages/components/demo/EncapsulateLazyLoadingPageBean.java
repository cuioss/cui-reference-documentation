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

import de.cuioss.tools.base.Preconditions;
import de.cuioss.tools.logging.CuiLogger;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static de.cuioss.tools.collect.CollectionLiterals.mutableList;

@ViewScoped
@Named
@ToString
@EqualsAndHashCode
public class EncapsulateLazyLoadingPageBean implements Serializable {

    @Serial
    private static final long serialVersionUID = -1281930098669716629L;

    private static final CuiLogger LOGGER = new CuiLogger(EncapsulateLazyLoadingPageBean.class);

    @Getter
    private boolean parentContainerRendered;

    @Getter
    private List<String> content;

    public String initViewAction() {
        this.parentContainerRendered = false;
        return null;
    }

    public boolean isInitialized() {
        Preconditions.checkState(parentContainerRendered, "In case parent CC isn't rendered, this code shouldn't be invoked, otherwise wrong behaviour");
        return false;
    }

    public void initialize() {
        // cui-rewrite:disable CuiLogRecordPatternRecipe
        LOGGER.info("Entering initialize at %s", LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(3);
            Preconditions.checkState(parentContainerRendered, "In case parent CC isn't rendered, this code shouldn't be invoked, otherwise wrong behaviour");
        } catch (InterruptedException e) {
            // cui-rewrite:disable CuiLogRecordPatternRecipe
            LOGGER.error(e, "interrupted: ");
            Thread.currentThread().interrupt();
        }
        // cui-rewrite:disable CuiLogRecordPatternRecipe
        LOGGER.info("Leaving initialize at %s", LocalDateTime.now());
        this.content = mutableList("A", "B", "C");
    }

    public void switchOverParentContainerRendered() {
        // cui-rewrite:disable CuiLogRecordPatternRecipe
        LOGGER.info("Entering switchOverParentContainerRendered at %s", LocalDateTime.now());
        this.parentContainerRendered = !parentContainerRendered;
    }
}
