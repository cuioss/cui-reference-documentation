package de.cuioss.portal.reference.pages.components.demo;

import de.cuioss.jsf.api.application.message.MessageProducer;
import de.cuioss.uimodel.field.DynamicFieldType;
import de.cuioss.uimodel.field.LabeledDynamicField;
import de.cuioss.uimodel.field.impl.BaseLabeledDynamicField;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("javadoc")
@ViewScoped
@Named
@EqualsAndHashCode
@ToString
public class InputGuardDemoBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 201827856732556695L;

    @Inject
    MessageProducer messageProducer;

    @Getter
    @Setter
    private String input1 = "Some Input to be guarded";

    @Getter
    @Setter
    private boolean guard2ButtonRendered = true;

    @Getter
    @Setter
    private Integer input2 = 10;

    @Getter
    @Setter
    private boolean guard2Rendered = true;

    @Getter
    @Setter
    private boolean guarded2State = false;

    @Getter
    private List<LabeledDynamicField<?>> inputList;

    @PostConstruct
    public void initBean() {
        inputList = new ArrayList<>();
        inputList.add(new BaseLabeledDynamicField<>(DynamicFieldType.STRING.createDynamicField("First", true), "first",
            "common.field.name.first", null));
        inputList.add(new BaseLabeledDynamicField<>(DynamicFieldType.STRING.createDynamicField("Second", true),
            "second", "common.field.name", null));
        inputList.add(new BaseLabeledDynamicField<>(DynamicFieldType.STRING.createDynamicField("", true), "other",
            "common.field.other", null));
    }

    public void guard2ValueChangeListener(ValueChangeEvent changeEvent) {
        messageProducer.addGlobalMessage("Detected Change for guard, new value=" + changeEvent.getNewValue(),
            FacesMessage.SEVERITY_INFO);
    }

    public void input2ValueChangeListener(ValueChangeEvent changeEvent) {
        messageProducer.addGlobalMessage("Detected Change for input2, new value=" + changeEvent.getNewValue(),
            FacesMessage.SEVERITY_INFO);
    }

}
