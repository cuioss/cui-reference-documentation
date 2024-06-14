package de.cuioss.portal.reference.pages.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Oliver Wolff
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = -7731754426127764870L;

    private String city;

    private String street;

    private String line1;

    private String line2;

    private boolean editable;

    /**
     * @param copyFrom must not be null
     */
    public Address(final Address copyFrom) {
        this.city = copyFrom.getCity();
        this.street = copyFrom.getStreet();
        this.line1 = copyFrom.getLine1();
        this.line2 = copyFrom.getLine2();
        this.editable = copyFrom.editable;
    }

}
