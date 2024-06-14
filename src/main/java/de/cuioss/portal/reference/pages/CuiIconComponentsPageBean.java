package de.cuioss.portal.reference.pages;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serial;
import java.io.Serializable;

@Named
@SessionScoped
@ToString
@EqualsAndHashCode
public class CuiIconComponentsPageBean implements Serializable {

    @Serial
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
