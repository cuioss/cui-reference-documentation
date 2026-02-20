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
package de.cuioss.portal.reference.pages;

import de.cuioss.jsf.api.application.message.MessageProducer;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author i001456
 */
@Named
@RequestScoped
@ToString
@EqualsAndHashCode
public class CuiIconsOverviewPageBean implements Serializable {

    private static final String CSS_BEFORE = ":before";

    private static final String CUI_ICON_PREFIX = "cui-icon-";

    private static final String RESOURCE_NAME = "icons.css";

    private static final String LIBRARY_NAME = "de.cuioss.portal.css";

    private static final String DUPLICATE_WARN_MSG_KEY = "java.CuiIconsOverviewPageBean.warning.duplicate.style";

    @Serial
    private static final long serialVersionUID = -6584517051621040849L;

    @Inject
    MessageProducer messageProducer;

    @Inject
    FacesContext facesContext;

    @Getter
    private List<String> data;

    @PostConstruct
    public void initBean() {
        data = new IconExtractor(CSS_BEFORE, CUI_ICON_PREFIX, DUPLICATE_WARN_MSG_KEY, facesContext, messageProducer)
            .fromResource(RESOURCE_NAME, LIBRARY_NAME);
    }
}
