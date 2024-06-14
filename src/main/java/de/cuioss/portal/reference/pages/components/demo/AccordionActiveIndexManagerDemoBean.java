package de.cuioss.portal.reference.pages.components.demo;

import de.cuioss.jsf.api.components.support.ActiveIndexManager;
import de.cuioss.jsf.api.components.support.ActiveIndexManagerImpl;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serial;
import java.io.Serializable;

import static de.cuioss.tools.collect.CollectionLiterals.immutableList;

@Named
@SessionScoped
@EqualsAndHashCode
@ToString
public class AccordionActiveIndexManagerDemoBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 8968258971793284937L;

    @Getter
    @Setter
    private ActiveIndexManager indexManager;

    @PostConstruct
    public void init() {
        indexManager = new ActiveIndexManagerImpl(immutableList(1));
    }
}
