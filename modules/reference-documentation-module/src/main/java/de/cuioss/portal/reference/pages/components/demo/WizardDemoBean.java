package de.cuioss.portal.reference.pages.components.demo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;

import de.cuioss.jsf.api.application.message.MessageProducer;
import de.cuioss.portal.ui.api.message.PortalMessageProducer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Named
@SessionScoped
@EqualsAndHashCode
@ToString
public class WizardDemoBean implements Serializable {

    private static final long serialVersionUID = 8903424637991951441L;

    @Inject
    @PortalMessageProducer
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
    public class User implements Serializable {

        private static final long serialVersionUID = 8730301286307340788L;

        private String firstname;

        private String lastname;

        private Integer age;

        private String street;

        private String city;

        private String postalCode;

    }
}
