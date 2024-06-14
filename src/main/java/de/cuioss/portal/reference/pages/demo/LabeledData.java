package de.cuioss.portal.reference.pages.demo;

import de.cuioss.uimodel.nameprovider.IDisplayNameProvider;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Oliver Wolff
 *
 */
@Data
public class LabeledData implements Serializable {

    /** serial version UID */
    @Serial
    private static final long serialVersionUID = 5114940089555214180L;

    private final IDisplayNameProvider<String> label;

    private final String data;

}
