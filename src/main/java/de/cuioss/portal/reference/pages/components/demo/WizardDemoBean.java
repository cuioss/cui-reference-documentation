package de.cuioss.portal.reference.pages.components.demo;

import de.cuioss.jsf.api.application.message.MessageProducer;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.*;
import org.primefaces.event.FlowEvent;

import java.io.Serial;
import java.io.Serializable;

@Named
@SessionScoped
@EqualsAndHashCode
@ToString
public class WizardDemoBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 8903424637991951441L;

    @Inject
    MessageProducer messageProducer;

    @Getter
    @Setter
    private User user = new User();

    @Setter
    @Getter
    private boolean skip;

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false; // reset in case user goes back
            return "confirm";
        }
        return event.getNewStep();
    }

    public void save() {
        messageProducer.addGlobalMessage("Person data {0} is saved.", FacesMessage.SEVERITY_INFO, user.getLastname());
    }

    @Data
    public static class User implements Serializable {

        @Serial
        private static final long serialVersionUID = 8730301286307340788L;

        private String firstname;

        private String lastname;

        private Integer age;

        private String street;

        private String city;

        private String postalCode;

    }
}
