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

import de.cuioss.jsf.api.application.message.MessageProducer;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.faces.event.ValueChangeListener;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@SessionScoped
@Named
@EqualsAndHashCode
@ToString
public class SwitchDemoBean implements Serializable, ValueChangeListener {

    @Serial
    private static final long serialVersionUID = -4087184778916301982L;

    @Getter
    @Setter
    private Boolean switchMinimal = Boolean.FALSE;

    @Getter
    @Setter
    private Boolean switchValueChangeListener = Boolean.FALSE;

    @Getter
    @Setter
    private Boolean switchFValueChangeListener = Boolean.FALSE;

    @Getter
    @Setter
    private Boolean switchFAjaxListener = Boolean.FALSE;

    @Getter
    @Setter
    private Boolean switchPrimeFaces = Boolean.FALSE;

    @Inject
    MessageProducer messageProducer;

    @Override
    public void processValueChange(final ValueChangeEvent event) throws AbortProcessingException {
        messageProducer.addGlobalMessage("ValueChange on ServerSide, new Value: " + event.getNewValue(),
            FacesMessage.SEVERITY_INFO);
    }

    public void valueChangeListener(final ValueChangeEvent event) {
        messageProducer.addGlobalMessage("ValueChangeListener fired. New Value: " + event.getNewValue(),
            FacesMessage.SEVERITY_INFO);
    }

    public void ajaxValueChangeListener(AjaxBehaviorEvent notUse) {
        messageProducer.addGlobalMessage("AjaxBehaviorEvent fired. New Value: " + switchFAjaxListener.toString(),
            FacesMessage.SEVERITY_INFO);
    }

    public void pfChangeListener() {
        messageProducer.addGlobalMessage("PrimeFaces listener fired. New Value: " + switchPrimeFaces.toString(),
            FacesMessage.SEVERITY_INFO);
    }
}
