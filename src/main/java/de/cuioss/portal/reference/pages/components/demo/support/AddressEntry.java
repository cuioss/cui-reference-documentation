package de.cuioss.portal.reference.pages.components.demo.support;

import de.cuioss.tools.string.MoreStrings;
import de.cuioss.uimodel.model.conceptkey.ConceptKeyType;
import de.cuioss.uimodel.nameprovider.IDisplayNameProvider;
import lombok.*;

import java.util.Optional;
import java.util.SortedSet;
import java.util.UUID;

import static de.cuioss.tools.string.MoreStrings.nullToEmpty;
import static java.util.Objects.isNull;

/**
 * Represents an Address that can be used in conjunction with provider search
 * and email-addressing. It provides at least an email-address
 * ({@link #getMailAddress()}) and an unique identifier ({@link #getId()})
 */
@Value
@Builder
@AllArgsConstructor
@ToString(exclude = "id", doNotUseGetters = true)
@EqualsAndHashCode(exclude = "id", doNotUseGetters = true)
@SuppressWarnings("javadoc")
public class AddressEntry implements IDisplayNameProvider<String>, Comparable<AddressEntry> {

    private static final long serialVersionUID = 3999901193271748149L;

    private final String organization;

    /** The associated specialties, may be empty but never null */
    @Singular
    private final SortedSet<ConceptKeyType> specialties;

    /**
     * Person name, typically consistent of first-name and last-name.
     */
    private final String personName;

    /**
     * Name, prefixed with the title of the person. Primarily intended for building
     * the "personal" part of an Internet address.
     */
    private final String personNameWithTitle;

    /** The email address of that person. */
    @NonNull
    private final String mailAddress;

    /**
     * The id. Required since address entry used in data tables with selection where
     * unique ID required to determine entry.
     */
    @Builder.Default
    private final String id = UUID.randomUUID().toString();

    /**
     * @return the displayed {@link #getPersonName()} and {@link #getOrganization()}
     */
    public String buildPersonal() {
        var personal = Optional.ofNullable(personNameWithTitle).orElse(personName);
        if (!MoreStrings.isEmpty(personal) && !MoreStrings.isEmpty(getOrganization())) {
            personal = personal.concat(" (").concat(organization).concat(")");
        }
        return personal;
    }

    /**
     * The personal display String (if available) or the email-address
     */
    @Override
    public String getContent() {
        final var builder = new StringBuilder();
        final var personal = buildPersonal();
        if (!isNull(personal)) {
            builder.append(personal);
        } else {
            builder.append(getMailAddress());
        }
        return builder.toString();
    }

    @Override
    public int compareTo(final AddressEntry o) {
        return nullToEmpty(getMailAddress()).compareTo(nullToEmpty(o.getMailAddress()));
    }

    public boolean hasPersonName() {
        return null != personName;
    }

    public boolean hasOrganization() {
        return null != organization;
    }

    public boolean hasSpecialty() {
        return null != specialties;
    }

}
