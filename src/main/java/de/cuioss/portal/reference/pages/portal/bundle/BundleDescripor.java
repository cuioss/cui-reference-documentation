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
package de.cuioss.portal.reference.pages.portal.bundle;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import static de.cuioss.tools.collect.CollectionLiterals.mutableList;

/**
 * @author Oliver Wolff
 */
@EqualsAndHashCode
@ToString
public class BundleDescripor implements Serializable {

    @Serial
    private static final long serialVersionUID = -3666995381280916356L;

    @Getter
    private final String name;

    @Getter
    private final List<BundleEntry> entries;

    /**
     * @param name
     * @param resourceBundle
     */
    public BundleDescripor(final String name, final ResourceBundle resourceBundle) {
        this.name = name;
        entries = new ArrayList<>();
        List<String> sortedNames = mutableList(resourceBundle.keySet());
        Collections.sort(sortedNames);
        for (String key : sortedNames) {
            entries.add(new BundleEntry(key, resourceBundle.getString(key)));
        }
    }

}
