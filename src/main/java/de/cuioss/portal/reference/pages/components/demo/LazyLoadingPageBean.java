package de.cuioss.portal.reference.pages.components.demo;

import de.cuioss.portal.ui.api.lazyloading.BaseLazyLoadingRequest;
import de.cuioss.portal.ui.api.lazyloading.LazyLoadingViewController;
import de.cuioss.tools.logging.CuiLogger;
import de.cuioss.uimodel.result.ResultObject;
import de.cuioss.uimodel.result.ResultState;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
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
@EqualsAndHashCode(callSuper = true)
public class LazyLoadingPageBean extends BaseLazyLoadingRequest<List<String>> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1825207529119003900L;

    private static final CuiLogger log = new CuiLogger(LazyLoadingPageBean.class);

    @Inject
    LazyLoadingViewController viewController;

    @Getter
    private List<String> content;

    public String initViewAction() {
        viewController.startRequest(this);
        return null;
    }

    @Override
    public ResultObject<List<String>> backendRequest() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            log.error("interrupted: ", e);
            Thread.currentThread().interrupt();
        }
        return new ResultObject<>(mutableList("A", "B", "C"), ResultState.VALID);
    }

    @Override
    public void handleResult(List<String> result) {
        content = result;
    }
}
