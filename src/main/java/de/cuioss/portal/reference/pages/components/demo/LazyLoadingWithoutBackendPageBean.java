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

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import static de.cuioss.tools.collect.CollectionLiterals.mutableList;

@ViewScoped
@Named
@ToString
@EqualsAndHashCode
public class LazyLoadingWithoutBackendPageBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 6519152791731588914L;
    @Getter
    private List<String> content;

    public void initialize() {
        content = mutableList("A", "B", "C");
    }
}
