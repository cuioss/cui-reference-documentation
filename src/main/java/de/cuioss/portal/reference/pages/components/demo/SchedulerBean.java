package de.cuioss.portal.reference.pages.components.demo;

import static de.cuioss.test.generator.Generators.letterStrings;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;

import lombok.Getter;

@Named
@SessionScoped
public class SchedulerBean implements Serializable {

    private static final long serialVersionUID = -7706563327276592213L;

    @Getter
    private DefaultScheduleModel schedule = new DefaultScheduleModel();

    @PostConstruct
    public void init() {
        var event = new DefaultScheduleEvent<String>();
        event.setData(letterStrings(5, 20).next());
        event.setStartDate(LocalDateTime.now().minusDays(1));
        event.setEndDate(LocalDateTime.now().minusDays(1).plusHours(1));

        schedule.addEvent(event);
    }

}
