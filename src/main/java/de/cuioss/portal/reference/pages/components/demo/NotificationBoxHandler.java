package de.cuioss.portal.reference.pages.components.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.cuioss.jsf.api.components.events.ModelPayloadEvent;
import de.cuioss.tools.logging.CuiLogger;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("javadoc")
@Named
@SessionScoped
@EqualsAndHashCode
@ToString
public class NotificationBoxHandler implements Serializable {

    private static final CuiLogger log = new CuiLogger(NotificationBoxHandler.class);

    private static final long serialVersionUID = 4046443512030148754L;

    private final SortedSet<Date> dismissCalls = new TreeSet<>(Comparator.comparingLong(Date::getTime));

    public void dismissedListener(final ModelPayloadEvent dismissEvent) {
        log.debug("Dismiss called '{}'", dismissEvent);
        dismissCalls.add(new Date());
        if (dismissCalls.size() > 5) {
            dismissCalls.remove(dismissCalls.first());
        }
    }

    public List<Date> getDismissCalls() {
        return new ArrayList<>(dismissCalls);
    }

}
