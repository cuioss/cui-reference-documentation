package de.cuioss.portal.reference.pages.components.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.cuioss.jsf.api.components.model.datalist.EditableDataListModel;
import de.cuioss.jsf.api.components.model.datalist.impl.AbstractEditableDataListModel;
import de.cuioss.jsf.bootstrap.CssBootstrap;
import de.cuioss.jsf.bootstrap.layout.LayoutMode;
import de.cuioss.portal.reference.pages.demo.Address;
import de.cuioss.portal.reference.pages.demo.AddressGenerator;
import de.cuioss.test.generator.Generators;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("javadoc")
@Named
@SessionScoped
@EqualsAndHashCode(exclude = { "addressModel" })
@ToString
public class EditableDataListDemoPageBean implements Serializable {

    private static final long serialVersionUID = -1027942011407811630L;

    @Getter
    private EditableDataListModel<Address> addressModel;

    @Getter
    @Setter
    private boolean enableEdit = true;

    @Getter
    @Setter
    private boolean enableNew = true;

    @Getter
    @Setter
    private boolean enableDelete = true;

    @Getter
    @Setter
    private boolean inlineEditMode = true;

    @Getter
    @Setter
    private boolean renderAddonButtonsInAddMode = true;

    @Getter
    @Setter
    private boolean renderAddonButtonsInEditMode = true;

    @Getter
    @Setter
    private boolean required = false;

    /**
     * Setting up the addresses
     */
    @PostConstruct
    public void init() {
        final var generator = Generators.asCollectionGenerator(new AddressGenerator());
        final List<Address> addresses = new ArrayList<>();

        for (var i = 0; i < 5; i++) {
            addresses.add(generator.next());
        }

        addressModel = new DemoEditableDataListModel(addresses);
    }

    public void save() {
        addressModel = new DemoEditableDataListModel(addressModel.getResultItems());
    }

    /**
     * If inlineEditMode is set to false, the forms style class is set to
     * "form-horizontal".
     *
     * @return styleClass
     */
    public String getFormStyleClass() {
        return inlineEditMode ? "" : CssBootstrap.FORM_HORIZONTAL.getStyleClass();
    }

    /**
     * @return label_sr_only if in inline edit mode
     */
    public String getLayoutModeForEditFields() {
        return inlineEditMode ? LayoutMode.LABEL_SR_ONLY.toString().toLowerCase() : "column";
    }

    /**
     * @author Sven Haag
     */
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    public class DemoEditableDataListModel extends AbstractEditableDataListModel<Address> {

        private static final long serialVersionUID = 6032708148974857517L;

        private final List<Address> addresses;

        /**
         * @param addresses demo data
         */
        public DemoEditableDataListModel(final List<Address> addresses) {
            this.addresses = addresses;
        }

        @Override
        public Address createEmptyItem() {
            return new Address();
        }

        @Override
        public Address createCopy(final Address item) {
            return new Address(item);
        }

        @Override
        public List<Address> getLoadedItems() {
            return addresses;
        }

        @Override
        public boolean isReadOnly(final Address element) {
            return element.isEditable();
        }
    }
}
