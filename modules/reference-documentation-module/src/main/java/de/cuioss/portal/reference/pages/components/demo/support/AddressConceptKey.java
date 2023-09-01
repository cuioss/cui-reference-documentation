package de.cuioss.portal.reference.pages.components.demo.support;

import java.util.Locale;

import de.cuioss.jsf.api.security.SanitizedIDNInternetAddress;
import de.cuioss.tools.string.Joiner;
import de.cuioss.tools.string.MoreStrings;
import de.cuioss.uimodel.model.conceptkey.AugmentationKeyConstans;
import de.cuioss.uimodel.model.conceptkey.ConceptKeyType;
import de.cuioss.uimodel.model.conceptkey.impl.BaseConceptCategory;
import de.cuioss.uimodel.model.conceptkey.impl.BaseConceptKeyType;
import de.cuioss.uimodel.nameprovider.I18nDisplayNameProvider;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.Delegate;

/**
 * Implementation of an {@link ConceptKeyType} which uses the
 * {@link AddressEntry} as delegate.
 *
 * @author Matthias Walliczek
 */
@ToString(of = "delegateAddress")
@EqualsAndHashCode(of = "delegateAddress", callSuper = false)
public class AddressConceptKey extends BaseConceptKeyType {

    private static final long serialVersionUID = -4182574259666973191L;

    @Delegate
    @Getter
    private final AddressEntry delegateAddress;

    private final String identifier;

    @Getter
    private final I18nDisplayNameProvider labelResolver;

    /**
     * Default constructor
     *
     * @param addressEntry the address entry to be used as delegatem, must not be
     *                     null
     */
    public AddressConceptKey(@NonNull final AddressEntry addressEntry) {
        super(new AddressConceptCategory());
        delegateAddress = addressEntry;
        identifier = Joiner.on("").skipNulls().join(delegateAddress.getMailAddress(), delegateAddress.getId());
        labelResolver = createResolver();
    }

    /**
     * To allow creation of new address entries by the user that are not part of the
     * recent mail address entries.
     *
     * @param addressEntry the address entry to be used as delegate.
     * @param undefined    true if the address entry is created as new
     */
    public AddressConceptKey(final AddressEntry addressEntry, final boolean undefined) {
        this(addressEntry);
        super.set(AugmentationKeyConstans.UNDEFINED_VALUE, Boolean.toString(undefined));
    }

    private I18nDisplayNameProvider createResolver() {
        var personal = getFormattedEmailAddress(delegateAddress);
        if (!MoreStrings.isEmpty(personal)) {
            return new I18nDisplayNameProvider(personal);
        }
        return new I18nDisplayNameProvider.Builder()
                .defaultValue(SanitizedIDNInternetAddress.decode(delegateAddress.getMailAddress())).build();
    }

    private static String getFormattedEmailAddress(AddressEntry address) {
        if (MoreStrings.isEmpty(address.getPersonName())) {
            return SanitizedIDNInternetAddress.encode(address.getMailAddress());
        }
        return address.getPersonName();
    }

    protected static class AddressConceptCategory extends BaseConceptCategory {

        private static final long serialVersionUID = -4046478743136916740L;
    }

    @Override
    public String getResolved(final Locale locale) {
        return labelResolver.lookupTextWithFallbackFirstFittingLanguageOnly(locale);
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public int compareTo(final ConceptKeyType o) {
        return getIdentifier().compareTo(o.getIdentifier());
    }

}
