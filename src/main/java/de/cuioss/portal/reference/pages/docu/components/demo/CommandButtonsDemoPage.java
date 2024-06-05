package de.cuioss.portal.reference.pages.docu.components.demo;

import de.cuioss.jsf.api.application.message.MessageProducer;
import de.cuioss.portal.common.bundle.ResourceBundleWrapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Named
@ApplicationScoped
@EqualsAndHashCode
@ToString
public class CommandButtonsDemoPage implements Serializable {

    @Serial
    private static final long serialVersionUID = -6837081477839627383L;

    @Inject
    ResourceBundleWrapper resourceBundle;

    @Inject
    FacesContext facesContext;

    @Inject
    MessageProducer messageProducer;

    public void executeActionWithSuccess() {
        var facesMessage = new FacesMessage("Success", "Well done!");
        facesContext.addMessage(null, facesMessage);
    }

}
