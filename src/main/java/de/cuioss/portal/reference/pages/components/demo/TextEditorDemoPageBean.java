package de.cuioss.portal.reference.pages.components.demo;

import lombok.Getter;
import lombok.Setter;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@SuppressWarnings("javadoc")
@Named
@SessionScoped
public class TextEditorDemoPageBean implements Serializable {

    private static final long serialVersionUID = 8327829832476118563L;

    @Getter
    @Setter
    private String simpleTextSample;

    @Getter
    @Setter
    private String otherTextSample;
}
