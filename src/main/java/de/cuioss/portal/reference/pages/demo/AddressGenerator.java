package de.cuioss.portal.reference.pages.demo;

import static de.cuioss.test.generator.Generators.fixedValues;
import static de.cuioss.test.generator.Generators.integers;

import de.cuioss.test.generator.TypedGenerator;
import de.cuioss.test.generator.internal.net.java.quickcheck.generator.PrimitiveGenerators;

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
        address.setEditable(PrimitiveGenerators.booleans().next());
        return address;
    }

    private String getAddressLine() {
        return new StringBuilder().append(STREET_NAMES.next()).append(" ").append(STREET_NUMBERS.next()).toString();
    }
}
