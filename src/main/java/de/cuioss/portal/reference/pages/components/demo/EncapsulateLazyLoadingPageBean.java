package de.cuioss.portal.reference.pages.components.demo;

import de.cuioss.tools.logging.CuiLogger;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static de.cuioss.tools.collect.CollectionLiterals.mutableList;

@SuppressWarnings("javadoc")
@ViewScoped
@Named
@ToString
@EqualsAndHashCode
public class EncapsulateLazyLoadingPageBean implements Serializable {

    @Serial
    private static final long serialVersionUID = -1281930098669716629L;

    private static final CuiLogger log = new CuiLogger(EncapsulateLazyLoadingPageBean.class);

    @Getter
    private boolean parentContainerRendered;

    @Getter
    private List<String> content;

    public String initViewAction() {
        this.parentContainerRendered = false;
        return null;
    }

    public boolean isInitialized() {
        if (!parentContainerRendered) {
            throw new IllegalStateException(
                "In case parent CC isn't rendered, this code shouldn't be invoked, " + "otherwise wrong behaviour");
        }
        return false;
    }

    public void initialize() {
        try {
            TimeUnit.SECONDS.sleep(3);
            if (!parentContainerRendered) {
                throw new IllegalStateException("In case parent CC isn't rendered, this code shouldn't be invoked, "
                    + "otherwise wrong behaviour");
            }
        } catch (InterruptedException e) {
            log.error("interrupted: ", e);
            Thread.currentThread().interrupt();
        }
        this.content = mutableList("A", "B", "C");
    }

    public void switchOverParentContainerRendered() {
        this.parentContainerRendered = !parentContainerRendered;
    }
}
