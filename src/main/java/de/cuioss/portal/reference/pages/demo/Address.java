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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Oliver Wolff
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = -7731754426127764870L;

    private String city;

    private String street;

    private String line1;

    private String line2;

    private boolean editable;

    /**
     * @param copyFrom must not be null
     */
    public Address(final Address copyFrom) {
        this.city = copyFrom.getCity();
        this.street = copyFrom.getStreet();
        this.line1 = copyFrom.getLine1();
        this.line2 = copyFrom.getLine2();
        this.editable = copyFrom.editable;
    }

}
