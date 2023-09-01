package de.cuioss.portal.reference.pages;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Named
@SessionScoped
@ToString
@EqualsAndHashCode
public class CuiIconComponentsPageBean implements Serializable {

    private static final long serialVersionUID = -3502943895881268139L;

    @Getter
    @Setter
    private String iconName = "cui-icon-shield";

    @Getter
    @Setter
    private String iconSize = "xxxl";

    @Getter
    @Setter
    private String iconState = "default";

    @Getter
    @Setter
    private String iconStyleClass = "";

    @Getter
    @Setter
    private String iconLibrary = "";

}
