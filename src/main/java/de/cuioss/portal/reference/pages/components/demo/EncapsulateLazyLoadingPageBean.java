package de.cuioss.portal.reference.pages.components.demo;

import de.cuioss.tools.base.Preconditions;
import de.cuioss.tools.logging.CuiLogger;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static de.cuioss.tools.collect.CollectionLiterals.mutableList;

@ViewScoped
@Named
@ToString
@EqualsAndHashCode
public class EncapsulateLazyLoadingPageBean implements Serializable {

    @Serial
    private static final long serialVersionUID = -1281930098669716629L;

    private static final CuiLogger LOGGER = new CuiLogger(EncapsulateLazyLoadingPageBean.class);

    @Getter
    private boolean parentContainerRendered;

    @Getter
    private List<String> content;

    public String initViewAction() {
        this.parentContainerRendered = false;
        return null;
    }

    public boolean isInitialized() {
        Preconditions.checkState(parentContainerRendered, "In case parent CC isn't rendered, this code shouldn't be invoked, otherwise wrong behaviour");
        return false;
    }

    public void initialize() {
        LOGGER.info("Entering initialize at %s", LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(3);
            Preconditions.checkState(parentContainerRendered, "In case parent CC isn't rendered, this code shouldn't be invoked, otherwise wrong behaviour");
        } catch (InterruptedException e) {
            LOGGER.error("interrupted: ", e);
            Thread.currentThread().interrupt();
        }
        LOGGER.info("Leaving initialize at %s", LocalDateTime.now());
        this.content = mutableList("A", "B", "C");
    }

    public void switchOverParentContainerRendered() {
        LOGGER.info("Entering switchOverParentContainerRendered at %s", LocalDateTime.now());
        this.parentContainerRendered = !parentContainerRendered;
    }
}
