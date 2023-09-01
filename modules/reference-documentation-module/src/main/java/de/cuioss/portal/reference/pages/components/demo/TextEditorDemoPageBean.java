package de.cuioss.portal.reference.pages.components.demo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

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
