package de.cuioss.portal.reference.pages.components.demo.support;

import de.cuioss.jsf.api.converter.AbstractConverter;
import de.cuioss.tools.string.MoreStrings;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

/**
 * To be used at new_mail -> To boot:tagInput. AddressConceptKeyConverter
 * handles only user entered mail address. Tag own converter  will handle mail address selected from options of
 * boot:tagInput.
 *
 * @author Matthias Walliczek
 */
@FacesConverter(value = "cui.AddressConceptKeyConverter")
public class AddressConceptKeyConverter extends AbstractConverter<AddressConceptKey> {

    @Override
    public AddressConceptKey convertToObject(final FacesContext context, final UIComponent component,
                                             final String value) throws ConverterException {
        if (MoreStrings.isBlank(value)) {
            return null;
        }

        return new AddressConceptKey(AddressEntry.builder().mailAddress(value).build());
    }

    @Override
    protected String convertToString(final FacesContext context, final UIComponent component,
                                     final AddressConceptKey value) throws ConverterException {

        return value.getResolved(null);
    }
}
