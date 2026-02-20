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

import de.cuioss.tools.logging.CuiLogger;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Named
@SessionScoped
@EqualsAndHashCode
@ToString
public class DialogDemoPageBean implements Serializable {

    private static final CuiLogger LOGGER = new CuiLogger(DialogDemoPageBean.class);

    @Serial
    private static final long serialVersionUID = 3744529779452625817L;

    @Getter
    private boolean renderLazyLoadingDialogContent;

    @Getter
    private boolean lazyLoadingDialogContentAvailable;

    public void showLazyLoadingDialog() {
        renderLazyLoadingDialogContent = true;
    }

    public void hideLazyLoadingDialog() {
        renderLazyLoadingDialogContent = false;
        lazyLoadingDialogContentAvailable = false;
    }

    public void initLazyLoadingDialogContent() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            /*~~(TODO: ERROR needs LogRecord. Suppress: // cui-rewrite:disable CuiLogRecordPatternRecipe)~~>*/LOGGER.error(e, "Error loading lazy dialog content");
            Thread.currentThread().interrupt();
        }
        lazyLoadingDialogContentAvailable = true;
    }
}
