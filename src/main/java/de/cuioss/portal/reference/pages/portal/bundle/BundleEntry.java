package de.cuioss.portal.reference.pages.portal.bundle;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Oliver Wolff
 *
 */
@Data
public class BundleEntry implements Serializable {

    @Serial
    private static final long serialVersionUID = -6133950962937608750L;

    private final String key;
    private final String value;

}
