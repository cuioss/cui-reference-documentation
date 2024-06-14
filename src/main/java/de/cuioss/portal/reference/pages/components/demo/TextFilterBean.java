package de.cuioss.portal.reference.pages.components.demo;

import de.cuioss.test.generator.internal.net.java.quickcheck.generator.PrimitiveGenerators;
import de.cuioss.tools.string.MoreStrings;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static de.cuioss.tools.collect.CollectionLiterals.mutableList;

@Named
@ViewScoped
@ToString
@EqualsAndHashCode
public class TextFilterBean implements Serializable {

    @Serial
    private static final long serialVersionUID = -6194987372878378012L;

    @Getter
    @Setter
    private String filter;

    private final List<String> sampleContent = mutableList();

    @Getter
    private List<String> content = Collections.emptyList();

    @PostConstruct
    public void init() {
        int sampleSize = PrimitiveGenerators.integers(4, 10).next();
        for (var i = 0; i < sampleSize; i++) {
            sampleContent.add(PrimitiveGenerators.letterStrings(5, 20).next());
        }
    }

    public void clearFilter() {
        filter = null;
    }

    public void initEntries() {
        if (MoreStrings.isEmpty(filter)) {
            content = sampleContent;
        } else {
            content = sampleContent.stream().filter(sample -> sample.toLowerCase().contains(filter.toLowerCase()))
                .collect(Collectors.toList());
        }
    }

}
