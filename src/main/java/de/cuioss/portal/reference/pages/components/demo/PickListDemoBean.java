package de.cuioss.portal.reference.pages.components.demo;

import de.cuioss.tools.logging.CuiLogger;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;

import static de.cuioss.tools.collect.CollectionLiterals.immutableList;

@Named
@SessionScoped
@EqualsAndHashCode
@ToString
public class PickListDemoBean implements Serializable {

    @Serial
    private static final long serialVersionUID = -4722969015860606113L;

    private static final CuiLogger log = new CuiLogger(PickListDemoBean.class);

    @Getter
    @Setter
    private DualListModel<String> picklistModel = new DualListModel<>(immutableList("one", "two", "three"),
            immutableList("four", "five", "six"));

    public void sortListener(final TransferEvent event) {
        log.debug(event.toString());
        Collections.sort(picklistModel.getTarget());
    }
}
