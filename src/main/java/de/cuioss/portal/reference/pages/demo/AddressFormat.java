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
package de.cuioss.portal.reference.pages.demo;

import de.cuioss.tools.collect.MapBuilder;
import de.cuioss.tools.string.Splitter;
import de.cuioss.uimodel.nameprovider.DisplayName;
import de.cuioss.uimodel.nameprovider.IDisplayNameProvider;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Oliver Wolff
 */
@Data
public class AddressFormat implements Serializable {

    /** serial version UID */
    @Serial
    private static final long serialVersionUID = 1779888605668368374L;

    private String pattern;

    private static final Map<String, IDisplayNameProvider<String>> LABEL_MAP = new MapBuilder<String, IDisplayNameProvider<String>>()
        .put("city", new DisplayName("City")).put("street", new DisplayName("Street"))
        .put("line1", new DisplayName("Line 1")).put("line2", new DisplayName("Line 2")).toMutableMap();

    /**
     * @param address to be formatted
     * @return the formatted address
     */
    public List<LabeledData> getFormated(final Address address) {

        final var splited = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(pattern);

        final List<LabeledData> result = new ArrayList<>(splited.size());

        final var data = extractDataForObject(address);

        for (final String name : splited) {

            final var propertyValue = data.get(name);

            if (null != propertyValue && !propertyValue.isEmpty()) {
                result.add(new LabeledData(LABEL_MAP.get(name), propertyValue));
            }

        }

        return result;
    }

    private static Map<String, String> extractDataForObject(final Address address) {

        /* alternative use bean util or reflection */

        final var builder = new MapBuilder<String, String>();
        builder.put("city", address.getCity()).put("street", address.getStreet()).put("line1", address.getLine1())
            .put("line2", address.getLine2());
        return builder.toMutableMap();
    }

}
