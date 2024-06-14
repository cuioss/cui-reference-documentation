package de.cuioss.portal.reference.pages.components.demo;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import static de.cuioss.tools.collect.CollectionLiterals.mutableList;

@ViewScoped
@Named
@ToString
@EqualsAndHashCode
public class LazyLoadingWithoutBackendPageBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 6519152791731588914L;
    @Getter
    private List<String> content;

    public void initialize() {
        content = mutableList("A", "B", "C");
    }
}
