package de.cuioss.portal.reference.pages.components.demo;

import static de.cuioss.tools.collect.CollectionLiterals.mutableList;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import de.cuioss.tools.logging.CuiLogger;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("javadoc")
@ViewScoped
@Named
@ToString
@EqualsAndHashCode
public class EncapsulateLazyLoadingPageBean implements Serializable {

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
