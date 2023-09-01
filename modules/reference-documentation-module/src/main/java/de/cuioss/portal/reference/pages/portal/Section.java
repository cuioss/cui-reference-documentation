package de.cuioss.portal.reference.pages.portal;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author Oliver Wolff
 *
 */
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Section implements Serializable {

    private static final long serialVersionUID = -5479383381273416003L;

    @Getter
    private final String name;

    @Getter
    private final String content;
}
