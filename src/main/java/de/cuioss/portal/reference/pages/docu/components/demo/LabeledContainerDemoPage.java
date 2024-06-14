package de.cuioss.portal.reference.pages.docu.components.demo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.primefaces.model.DualListModel;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import static de.cuioss.tools.collect.CollectionLiterals.mutableList;

@Named
@ApplicationScoped
@EqualsAndHashCode
@ToString
public class LabeledContainerDemoPage implements Serializable {

    @Serial
    private static final long serialVersionUID = -5911089483400770358L;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private DualListModel<String> cities = new DualListModel<>();

    @Getter
    @Setter
    private boolean labelInfoCollapsed = true;

    @Getter
    private final List<String> list = mutableList("a", "b", "c", "d");

    @Getter
    @Setter
    private LocalDateTime dateTime;

    public void toggleLabelInfo() {
        labelInfoCollapsed = !labelInfoCollapsed;
    }

    public List<String> autocomplete(String query) {
        return list;
    }

    /**
     * Store data
     */
    public void storeData() {
        // Your data can be stored here
    }
}
