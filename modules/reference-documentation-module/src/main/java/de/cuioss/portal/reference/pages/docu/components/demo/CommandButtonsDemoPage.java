package de.cuioss.portal.reference.pages.docu.components.demo;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import de.cuioss.jsf.api.application.message.MessageProducer;
import de.cuioss.portal.core.bundle.PortalResourceBundle;
import de.cuioss.portal.ui.api.message.PortalMessageProducer;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Named
@ApplicationScoped
@EqualsAndHashCode
@ToString
public class CommandButtonsDemoPage implements Serializable {

    private static final long serialVersionUID = -6837081477839627383L;

    @Inject
    @PortalResourceBundle
    ResourceBundle resourceBundle;

    @Inject
    FacesContext facesContext;

    @Inject
    @PortalMessageProducer
    MessageProducer messageProducer;

    public void executeActionWithSuccess() {
        var facesMessage = new FacesMessage("Success", "Well done!");
        facesContext.addMessage(null, facesMessage);
    }

}
