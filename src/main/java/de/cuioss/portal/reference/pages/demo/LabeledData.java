package de.cuioss.portal.reference.pages.demo;

import java.io.Serializable;

import de.cuioss.uimodel.nameprovider.IDisplayNameProvider;
import lombok.Data;

/**
 * @author Oliver Wolff
 *
 */
@Data
public class LabeledData implements Serializable {

    /** serial version UID */
    private static final long serialVersionUID = 5114940089555214180L;

    private final IDisplayNameProvider<String> label;

    private final String data;

}
