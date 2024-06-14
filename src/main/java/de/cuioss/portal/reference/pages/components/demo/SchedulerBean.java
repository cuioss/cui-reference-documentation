package de.cuioss.portal.reference.pages.components.demo;

import lombok.Getter;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

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
