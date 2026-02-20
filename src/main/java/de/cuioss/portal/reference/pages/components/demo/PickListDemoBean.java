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

import de.cuioss.tools.logging.CuiLogger;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;

import static de.cuioss.tools.collect.CollectionLiterals.immutableList;

@Named
@SessionScoped
@EqualsAndHashCode
@ToString
public class PickListDemoBean implements Serializable {

    @Serial
    private static final long serialVersionUID = -4722969015860606113L;

    private static final CuiLogger LOGGER = new CuiLogger(PickListDemoBean.class);

    @Getter
    @Setter
    private DualListModel<String> picklistModel = new DualListModel<>(immutableList("one", "two", "three"),
        immutableList("four", "five", "six"));

    public void sortListener(final TransferEvent event) {
        LOGGER.debug(event.toString());
        Collections.sort(picklistModel.getTarget());
    }
}
