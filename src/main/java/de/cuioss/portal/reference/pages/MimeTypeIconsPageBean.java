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

import de.cuioss.jsf.bootstrap.icon.MimeTypeIcon;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Oliver Wolff
 */
@Named
@RequestScoped
@ToString
@EqualsAndHashCode
public class MimeTypeIconsPageBean implements Serializable {

    /**
     * serial version UID
     */
    @Serial
    private static final long serialVersionUID = -6584517051621040849L;

    @Getter
    private List<MimeTypeIcon> data;

    /**
     * Initializes the mime-types
     */
    @PostConstruct
    public void initData() {
        data = new ArrayList<>(MimeTypeIcon.values().length);
        data.addAll(Arrays.asList(MimeTypeIcon.values()));
    }

}
