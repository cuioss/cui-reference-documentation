package de.cuioss.portal.reference.pages.demo;

import de.cuioss.test.generator.Generators;
import de.cuioss.test.generator.TypedGenerator;

import static de.cuioss.test.generator.Generators.fixedValues;
import static de.cuioss.test.generator.Generators.integers;

/**
 * Simple Generator for creating {@link Address}es
 *
 * @author Oliver Wolff
 */
public class AddressGenerator implements TypedGenerator<Address> {

    private static final TypedGenerator<String> STREET_NAMES = fixedValues("Hautpstr.", "Nebengäßchen", "Other Street",
            "That Street");

    private static final TypedGenerator<Integer> STREET_NUMBERS = integers(1, 128);

    private static final TypedGenerator<String> CITIES = fixedValues("Walldorf", "Heidelberg", "Mannheim", "Wiesloch",
            "Karlsruhe", "München", "Baden Baden", "Ludwigshafen");

    @Override
    public Address next() {
        final var address = new Address();
        address.setCity(CITIES.next());
        address.setStreet(getAddressLine());
        address.setLine1(getAddressLine());
        address.setEditable(Generators.booleans().next());
        return address;
    }

    private String getAddressLine() {
        return STREET_NAMES.next() + " " + STREET_NUMBERS.next();
    }
}
