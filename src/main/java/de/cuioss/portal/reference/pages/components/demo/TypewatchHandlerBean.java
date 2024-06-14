package de.cuioss.portal.reference.pages.components.demo;

import de.cuioss.tools.string.MoreStrings;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import static de.cuioss.tools.collect.CollectionLiterals.mutableList;

@Named
@SessionScoped
@EqualsAndHashCode
@ToString
public class TypewatchHandlerBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 1077509491729857258L;

    @Getter
    @Setter
    private String input;

    @Getter
    private final List<String> entries = mutableList();

    public void listener() {
        if (!MoreStrings.isEmpty(input)) {
            entries.add(input);
        }
    }

}
