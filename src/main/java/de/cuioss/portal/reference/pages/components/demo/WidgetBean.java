package de.cuioss.portal.reference.pages.components.demo;

import java.util.Random;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import de.cuioss.portal.ui.api.dashboard.BaseLazyLoadingWidget;
import de.cuioss.uimodel.nameprovider.DisplayName;
import de.cuioss.uimodel.nameprovider.LabeledKey;
import de.cuioss.uimodel.result.ResultDetail;
import de.cuioss.uimodel.result.ResultObject;
import de.cuioss.uimodel.result.ResultState;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("javadoc")
@Named
@ViewScoped
@ToString(of = { "content" }, callSuper = true)
@EqualsAndHashCode(of = { "content" }, callSuper = true)
public class WidgetBean extends BaseLazyLoadingWidget<String> {

    private static final long serialVersionUID = 6027808398818076494L;

    @Override
    public LabeledKey getTitle() {
        return new LabeledKey("page.portal.widget.title");
    }

    @Override
    public String getId() {
        return null;
    }

    @Getter
    private String content;

    @Getter
    private int repeats;

    @Override
    public ResultObject<String> backendRequest() {
        if (new Random().nextInt() % 3 != 0) {
            return new ResultObject<>("Test", ResultState.VALID);
        }
        return new ResultObject<>("", ResultState.ERROR, new ResultDetail(new DisplayName("error")), null);
    }

    @Override
    public void handleResult(String result) {
        content = result;
        repeats = new Random().nextInt() % 5;
    }
}
