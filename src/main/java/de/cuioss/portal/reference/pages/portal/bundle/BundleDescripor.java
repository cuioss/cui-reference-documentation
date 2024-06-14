package de.cuioss.portal.reference.pages.portal.bundle;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import static de.cuioss.tools.collect.CollectionLiterals.mutableList;

/**
 * @author Oliver Wolff
 */
@EqualsAndHashCode
@ToString
public class BundleDescripor implements Serializable {

    @Serial
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
