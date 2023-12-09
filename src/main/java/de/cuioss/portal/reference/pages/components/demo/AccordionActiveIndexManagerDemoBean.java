package de.cuioss.portal.reference.pages.components.demo;

import static de.cuioss.tools.collect.CollectionLiterals.immutableList;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.cuioss.jsf.api.components.support.ActiveIndexManager;
import de.cuioss.jsf.api.components.support.ActiveIndexManagerImpl;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("javadoc")
@Named
@SessionScoped
@EqualsAndHashCode
@ToString
public class AccordionActiveIndexManagerDemoBean implements Serializable {

    private static final long serialVersionUID = 8968258971793284937L;

    @Getter
    @Setter
    private ActiveIndexManager indexManager;

    @PostConstruct
    public void init() {
        indexManager = new ActiveIndexManagerImpl(immutableList(1));
    }
}
