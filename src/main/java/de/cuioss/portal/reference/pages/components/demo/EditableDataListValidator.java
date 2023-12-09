package de.cuioss.portal.reference.pages.components.demo;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;

import de.cuioss.jsf.api.components.model.datalist.EditableDataListModel;
import de.cuioss.jsf.api.validator.AbstractValidator;

@SuppressWarnings({ "javadoc" })
@FacesValidator("demo.EditableDataListValidator")
public class EditableDataListValidator extends AbstractValidator<EditableDataListModel<?>> {

    @Override
    protected void validateTypeSave(final FacesContext context, final UIComponent component,
            final EditableDataListModel<?> model) {
        if (null != model && model.getResultItems().size() == 5) {
            throwValidatorException("page.editabledatalist.validationerror");
        }
    }
}
