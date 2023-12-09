package de.cuioss.portal.reference.pages.portal.bundle;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Oliver Wolff
 *
 */
@Data
public class BundleEntry implements Serializable {

    private static final long serialVersionUID = -6133950962937608750L;

    private final String key;
    private final String value;

}
