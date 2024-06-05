package de.cuioss.portal.reference.pages.components.demo;

import de.cuioss.portal.ui.api.ui.lazyloading.BaseLazyLoadingRequest;
import de.cuioss.portal.ui.api.ui.lazyloading.LazyLoadingViewController;
import de.cuioss.tools.logging.CuiLogger;
import de.cuioss.uimodel.result.ResultObject;
import de.cuioss.uimodel.result.ResultState;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import static de.cuioss.tools.collect.CollectionLiterals.mutableList;

@SuppressWarnings("javadoc")
@ViewScoped
@Named
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MultipleLazyLoadingPageBean extends BaseLazyLoadingRequest<List<String>> implements Serializable {

    @Serial
    private static final long serialVersionUID = 3231631758524048548L;

    private static final CuiLogger log = new CuiLogger(MultipleLazyLoadingPageBean.class);

    @Inject
    LazyLoadingViewController viewController;

    @Getter
    private List<String> content;

    @Getter
    @Setter
    private String selected;

    public String initViewAction() {
        viewController.startRequest(this);
        return null;
    }

    @Override
    public ResultObject<List<String>> backendRequest() {
        try {
            Thread.sleep(5000);
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
