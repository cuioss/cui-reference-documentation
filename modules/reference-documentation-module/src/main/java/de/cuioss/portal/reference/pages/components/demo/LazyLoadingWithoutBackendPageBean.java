package de.cuioss.portal.reference.pages.components.demo;

import static de.cuioss.tools.collect.CollectionLiterals.mutableList;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("javadoc")
@ViewScoped
@Named
@ToString
@EqualsAndHashCode
public class LazyLoadingWithoutBackendPageBean implements Serializable {

    private static final long serialVersionUID = 6519152791731588914L;
    @Getter
    private List<String> content;

    public void initialize() {
        content = mutableList("A", "B", "C");
    }
}
