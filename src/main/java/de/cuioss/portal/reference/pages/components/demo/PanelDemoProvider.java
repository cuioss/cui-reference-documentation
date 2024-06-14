package de.cuioss.portal.reference.pages.components.demo;

import de.cuioss.jsf.api.ui.model.ToggleSwitch;
import de.cuioss.tools.logging.CuiLogger;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Data provider for the panel demo page
 *
 * @author Sven Haag
 */
@Named
@SessionScoped
@EqualsAndHashCode
@ToString
public class PanelDemoProvider implements Serializable {

    private static final CuiLogger log = new CuiLogger(PanelDemoProvider.class);

    @Serial
    private static final long serialVersionUID = 260766844925472554L;

    @Getter
    @Setter
    private ToggleSwitch toggleSwitch = new ToggleSwitch(Boolean.FALSE);

    @Getter
    @Setter
    private boolean bool = true;

    /**
     * @return test data with delay
     */
    public String getData() {
        log.debug("Delayed data request started. waiting some time...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("Delayed data delivery interrupted", e);
            Thread.currentThread().interrupt();
        }
        log.debug("Delivering delayed data.");
        return "Delayed data, called at: " + LocalDateTime.now().format(DateTimeFormatter.ISO_TIME);
    }
}
