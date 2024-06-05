package de.cuioss.portal.reference.pages.components.demo;

import de.cuioss.jsf.api.application.message.MessageProducer;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.faces.event.ValueChangeListener;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@SuppressWarnings("javadoc")
@SessionScoped
@Named
@EqualsAndHashCode
@ToString
public class SwitchDemoBean implements Serializable, ValueChangeListener {

    @Serial
    private static final long serialVersionUID = -4087184778916301982L;

    @Getter
    @Setter
    private Boolean switchMinimal = Boolean.FALSE;

    @Getter
    @Setter
    private Boolean switchValueChangeListener = Boolean.FALSE;

    @Getter
    @Setter
    private Boolean switchFValueChangeListener = Boolean.FALSE;

    @Getter
    @Setter
    private Boolean switchFAjaxListener = Boolean.FALSE;

    @Getter
    @Setter
    private Boolean switchPrimeFaces = Boolean.FALSE;

    @Inject
    MessageProducer messageProducer;

    @Override
    public void processValueChange(final ValueChangeEvent event) throws AbortProcessingException {
        messageProducer.addGlobalMessage("ValueChange on ServerSide, new Value: " + event.getNewValue(),
            FacesMessage.SEVERITY_INFO);
    }

    public void valueChangeListener(final ValueChangeEvent event) {
        messageProducer.addGlobalMessage("ValueChangeListener fired. New Value: " + event.getNewValue(),
            FacesMessage.SEVERITY_INFO);
    }

    public void ajaxValueChangeListener() {
        messageProducer.addGlobalMessage("AjaxBehaviorEvent fired. New Value: " + switchFAjaxListener.toString(),
            FacesMessage.SEVERITY_INFO);
    }

    public void pfChangeListener() {
        messageProducer.addGlobalMessage("PrimeFaces listener fired. New Value: " + switchPrimeFaces.toString(),
            FacesMessage.SEVERITY_INFO);
    }
}
