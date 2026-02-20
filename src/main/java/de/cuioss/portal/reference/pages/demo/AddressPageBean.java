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

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
@ToString
@EqualsAndHashCode
public class AddressPageBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 6996292920006494613L;

    private final AddressFormat usFormat = new AddressFormat();

    private final AddressFormat deFormat = new AddressFormat();

    private final Address data = new Address();

    /**
     * Constructor.
     */
    public AddressPageBean() {

        usFormat.setPattern("city, street, line1, line2");
        deFormat.setPattern("street, line2, line1, city");

        data.setLine1("line1");
        data.setLine2("line2");
        data.setCity("city");
        data.setStreet("street");
    }

    /**
     * @return the us formatted address
     */
    public List<LabeledData> getUsFormatedAddress() {
        return usFormat.getFormated(data);
    }

    /**
     * @return the de formatted address
     */
    public List<LabeledData> getDeFormatedAddress() {
        return deFormat.getFormated(data);
    }

}
