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

import de.cuioss.portal.ui.api.lazyloading.BaseLazyLoadingRequest;
import de.cuioss.portal.ui.api.lazyloading.LazyLoadingViewController;
import de.cuioss.tools.logging.CuiLogger;
import de.cuioss.uimodel.result.ResultObject;
import de.cuioss.uimodel.result.ResultState;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
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
@EqualsAndHashCode(callSuper = true)
public class LazyLoadingPageBean extends BaseLazyLoadingRequest<List<String>> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1825207529119003900L;

    private static final CuiLogger LOGGER = new CuiLogger(LazyLoadingPageBean.class);

    @Inject
    LazyLoadingViewController viewController;

    @Getter
    private List<String> content;

    public void startInitialize() {
        /*~~(TODO: INFO needs LogRecord. Suppress: // cui-rewrite:disable CuiLogRecordPatternRecipe)~~>*/LOGGER.info("Executing startInitialize");
        viewController.startRequest(this);
    }

    @Override
    public ResultObject<List<String>> backendRequest() {
        /*~~(TODO: INFO needs LogRecord. Suppress: // cui-rewrite:disable CuiLogRecordPatternRecipe)~~>*/LOGGER.info("Entering BackendRequest at %s", LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            /*~~(TODO: ERROR needs LogRecord. Suppress: // cui-rewrite:disable CuiLogRecordPatternRecipe)~~>*/LOGGER.error(e, "interrupted: ");
            Thread.currentThread().interrupt();
        }
        /*~~(TODO: INFO needs LogRecord. Suppress: // cui-rewrite:disable CuiLogRecordPatternRecipe)~~>*/LOGGER.info("Leaving BackendRequest at %s", LocalDateTime.now());
        return new ResultObject<>(mutableList("A", "B", "C"), ResultState.VALID);
    }

    @Override
    public void handleResult(List<String> result) {
        content = result;
    }
}
