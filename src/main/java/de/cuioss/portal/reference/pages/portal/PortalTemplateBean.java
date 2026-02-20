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
package de.cuioss.portal.reference.pages.portal;

import de.cuioss.portal.ui.api.templating.PortalTemplateDescriptor;
import de.cuioss.portal.ui.runtime.application.templating.PortalCoreTemplates;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Oliver Wolff
 */
@Named
@ApplicationScoped
@EqualsAndHashCode
@ToString
public class PortalTemplateBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 638283726301069378L;

    private static final String TEMPLATE_BASE_PATH = "/META-INF/templates/portal/";
    private static final String TEMPLATE_USAGE_PATH = "/templates/";

    @Inject
    @PortalTemplateDescriptor
    PortalCoreTemplates portalTemplates;

    @Getter
    private List<TemplateDescriptor> templateDescriptor;

    /**
     *
     */
    @PostConstruct
    public void init() {
        this.templateDescriptor = new ArrayList<>();
        for (final String path : this.portalTemplates.getHandledTemplates()) {
            this.templateDescriptor.add(new TemplateDescriptor(TEMPLATE_USAGE_PATH + path, TEMPLATE_BASE_PATH + path));
        }
    }
}
