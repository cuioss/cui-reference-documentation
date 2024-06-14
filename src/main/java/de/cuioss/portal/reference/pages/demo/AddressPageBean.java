package de.cuioss.portal.reference.pages.demo;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
@ToString
@EqualsAndHashCode
public class AddressPageBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 6996292920006494613L;

    private final AddressFormat usFormat = new AddressFormat();

    private final AddressFormat deFormat = new AddressFormat();

    private final Address data = new Address();

    /**
     * Constructor.
     */
    public AddressPageBean() {

        usFormat.setPattern("city, street, line1, line2");
        deFormat.setPattern("street, line2, line1, city");

        data.setLine1("line1");
        data.setLine2("line2");
        data.setCity("city");
        data.setStreet("street");
    }

    /**
     * @return the us formatted address
     */
    public List<LabeledData> getUsFormatedAddress() {
        return usFormat.getFormated(data);
    }

    /**
     * @return the de formatted address
     */
    public List<LabeledData> getDeFormatedAddress() {
        return deFormat.getFormated(data);
    }

}
