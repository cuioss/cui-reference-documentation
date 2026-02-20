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
package de.cuioss.portal.reference.pages.docu.components.demo;

import de.cuioss.jsf.api.application.message.MessageProducer;
import de.cuioss.portal.common.bundle.ResourceBundleWrapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Named
@ApplicationScoped
@EqualsAndHashCode
@ToString
public class CommandButtonsDemoPage implements Serializable {

    @Serial
    private static final long serialVersionUID = -6837081477839627383L;

    @Inject
    ResourceBundleWrapper resourceBundle;

    @Inject
    FacesContext facesContext;

    @Inject
    MessageProducer messageProducer;

    public void executeActionWithSuccess() {
        var facesMessage = new FacesMessage("Success", "Well done!");
        facesContext.addMessage(null, facesMessage);
    }

}
