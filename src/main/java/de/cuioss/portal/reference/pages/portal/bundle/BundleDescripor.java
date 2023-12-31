package de.cuioss.portal.reference.pages.portal.bundle;

import static de.cuioss.tools.collect.CollectionLiterals.mutableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Oliver Wolff
 */
@EqualsAndHashCode
@ToString
public class BundleDescripor implements Serializable {

    private static final long serialVersionUID = -3666995381280916356L;

    @Getter
    private final String name;

    @Getter
    private final List<BundleEntry> entries;

    /**
     * @param name
     * @param resourceBundle
     */
    public BundleDescripor(final String name, final ResourceBundle resourceBundle) {
        this.name = name;
        entries = new ArrayList<>();
        List<String> sortedNames = mutableList(resourceBundle.keySet());
        Collections.sort(sortedNames);
        for (String key : sortedNames) {
            entries.add(new BundleEntry(key, resourceBundle.getString(key)));
        }
    }

}
