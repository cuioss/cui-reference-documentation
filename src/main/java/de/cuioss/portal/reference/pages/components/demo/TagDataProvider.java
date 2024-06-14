package de.cuioss.portal.reference.pages.components.demo;

import de.cuioss.jsf.api.application.message.MessageProducer;
import de.cuioss.jsf.api.components.events.ModelPayloadEvent;
import de.cuioss.jsf.bootstrap.button.CloseCommandButton;
import de.cuioss.jsf.bootstrap.tag.TagComponent;
import de.cuioss.portal.reference.pages.components.demo.support.AddressConceptKey;
import de.cuioss.portal.reference.pages.components.demo.support.AddressEntry;
import de.cuioss.test.generator.Generators;
import de.cuioss.test.generator.domain.NameGenerators;
import de.cuioss.tools.logging.CuiLogger;
import de.cuioss.tools.string.Joiner;
import de.cuioss.uimodel.model.conceptkey.AugmentationKeyConstans;
import de.cuioss.uimodel.model.conceptkey.ConceptCategory;
import de.cuioss.uimodel.model.conceptkey.ConceptKeyType;
import de.cuioss.uimodel.model.conceptkey.impl.ConceptKeyTypeImpl;
import de.cuioss.uimodel.nameprovider.I18nDisplayNameProvider;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import static de.cuioss.tools.collect.CollectionLiterals.immutableSet;

@Named
@ViewScoped
@EqualsAndHashCode
@ToString
public class TagDataProvider implements Serializable {

    @Serial
    private static final long serialVersionUID = -3513331142570721330L;

    private static final CuiLogger log = new CuiLogger(TagDataProvider.class);

    @Inject
    MessageProducer messageProducer;

    private List<String> firstNames;

    @Getter
    private Set<ConceptKeyType> firstNamesTypes;

    @Getter
    @Setter
    private Set<ConceptKeyType> simpleValueSample;

    @Getter
    @Setter
    private Set<ConceptKeyType> requiredValueSample;

    @Getter
    @Setter
    private Set<AddressConceptKey> addresses;

    @Getter
    @Setter
    private Set<AddressConceptKey> selectedAddress;

    public static final ConceptCategory DemoConceptCategory = new ConceptCategory() {

        @Serial
        private static final long serialVersionUID = -8540044363744809139L;

        @Override
        public String getName() {
            return "demo";
        }

        @Override
        public ConceptKeyType createUndefinedConceptKey(final String value) {
            return ConceptKeyTypeImpl.builder().identifier(value).labelResolver(new I18nDisplayNameProvider(value))
                .category(this).augmentation(AugmentationKeyConstans.UNDEFINED_VALUE, Boolean.TRUE.toString())
                .build();
        }
    };

    /**
     *
     */
    @PostConstruct
    public void init() {
        var names = Generators.asCollectionGenerator(NameGenerators.FIRSTNAMES_ANY_ENGLISH.generator());
        firstNames = names.list(10);
        firstNamesTypes = new HashSet<>();
        for (final String name : firstNames) {
            firstNamesTypes.add(ConceptKeyTypeImpl.builder().identifier(name).category(DemoConceptCategory)
                .labelResolver(new I18nDisplayNameProvider(name)).build());
        }

        addresses = new HashSet<>();
        addresses.add(new AddressConceptKey(AddressEntry.builder().id("address_foo").mailAddress("foo@bar.com")
            .personName("Foo Bar").organization("Org1").build()));
        addresses.add(new AddressConceptKey(AddressEntry.builder().id("address_without_name").mailAddress("baz@buz.com")
            .organization("Org2").build()));
        addresses.add(new AddressConceptKey(AddressEntry.builder().id("address_bla").mailAddress("bla@blub.com")
            .personName("Bla Blub").organization("Org3").build()));
    }

    public List<String> getFirstNames() {
        log.info("Available firstnames : {}", firstNames);
        return firstNames;
    }

    /**
     * Listener for Server dispose events.
     *
     * @param disposeEvent {@link ModelPayloadEvent} include content od disposed
     *                     element
     */
    public void disposeListener(final ModelPayloadEvent disposeEvent) {
        log.info("Dispose : {}", disposeEvent.getModel());
        firstNames.remove(disposeEvent.getModel());
        messageProducer.addGlobalMessage("Disposed=" + disposeEvent.getModel(), FacesMessage.SEVERITY_INFO);
    }

    /**
     * Execute on click "Dispose" for a tag component
     *
     * @param event {@link AjaxBehaviorEvent} must not be {@code null}
     */
    public void executeRemove(final AjaxBehaviorEvent event) {
        final var source = (CloseCommandButton) event.getSource();
        final var model = ((TagComponent) source.getParent()).getModel();
        firstNames.remove(model);
        messageProducer.addGlobalMessage("Disposed=" + model, FacesMessage.SEVERITY_INFO);
    }

    /**
     * @param changeEvent
     */
    public void valueChange(final ValueChangeEvent changeEvent) {
        @SuppressWarnings("unchecked") final var result = (Set<ConceptKeyType>) changeEvent.getNewValue();
        final List<String> names = result.stream().map(type -> type.getResolved(Locale.getDefault()))
            .collect(Collectors.toList());
        messageProducer.addGlobalMessage("ValueChange=" + Joiner.on(" ").join(names), FacesMessage.SEVERITY_INFO);
    }

    @SuppressWarnings({"unused", "unchecked"}) // Defined by the API
    public void validate(final FacesContext context, final UIComponent component, final Object value) {
        if (null != value) {
            final var items = (Set<ConceptKeyType>) value;
            final Set<String> blacklist = immutableSet(firstNames.get(0), firstNames.get(1));
            if (items.stream().anyMatch(c -> blacklist.contains(c.getIdentifier()))) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Don't add any of: " + blacklist, "Don't add any of: " + blacklist));
            }
        }
    }
}
