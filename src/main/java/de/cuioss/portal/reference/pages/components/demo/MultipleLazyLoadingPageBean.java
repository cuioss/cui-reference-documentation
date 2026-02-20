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
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import static de.cuioss.tools.collect.CollectionLiterals.mutableList;

@ViewScoped
@Named
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MultipleLazyLoadingPageBean extends BaseLazyLoadingRequest<List<String>> implements Serializable {

    @Serial
    private static final long serialVersionUID = 3231631758524048548L;

    private static final CuiLogger LOGGER = new CuiLogger(MultipleLazyLoadingPageBean.class);

    @Inject
    LazyLoadingViewController viewController;

    @Getter
    private List<String> content;

    @Getter
    @Setter
    private String selected;

    public String initViewAction() {
        viewController.startRequest(this);
        return null;
    }

    // ResultObject is deprecated but still required by LazyLoadingRequest API
    @SuppressWarnings("deprecation")
    @Override
    public ResultObject<List<String>> backendRequest() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // cui-rewrite:disable CuiLogRecordPatternRecipe
            LOGGER.error(e, "interrupted: ");
            Thread.currentThread().interrupt();
        }
        return new ResultObject<>(mutableList("A", "B", "C"), ResultState.VALID);
    }

    @Override
    public void handleResult(List<String> result) {
        content = result;
    }
}
