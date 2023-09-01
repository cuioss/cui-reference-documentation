package de.cuioss.portal.reference.pages.components.demo;

import static de.cuioss.tools.collect.CollectionLiterals.mutableList;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.cuioss.tools.string.MoreStrings;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("javadoc")
@Named
@SessionScoped
@EqualsAndHashCode
@ToString
public class TypewatchHandlerBean implements Serializable {

    private static final long serialVersionUID = 1077509491729857258L;

    @Getter
    @Setter
    private String input;

    @Getter
    private List<String> entries = mutableList();

    public void listener() {
        if (!MoreStrings.isEmpty(input)) {
            entries.add(input);
        }
    }

}
