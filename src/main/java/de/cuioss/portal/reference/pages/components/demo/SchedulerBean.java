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

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import static de.cuioss.test.generator.Generators.letterStrings;

@Named
@SessionScoped
public class SchedulerBean implements Serializable {

    @Serial
    private static final long serialVersionUID = -7706563327276592213L;

    @Getter
    private final DefaultScheduleModel schedule = new DefaultScheduleModel();

    @PostConstruct
    public void init() {
        var event = new DefaultScheduleEvent<String>();
        event.setData(letterStrings(5, 20).next());
        event.setStartDate(LocalDateTime.now().minusDays(1));
        event.setEndDate(LocalDateTime.now().minusDays(1).plusHours(1));

        schedule.addEvent(event);
    }

}
