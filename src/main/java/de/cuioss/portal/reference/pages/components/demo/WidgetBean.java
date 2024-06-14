package de.cuioss.portal.reference.pages.components.demo;

import de.cuioss.portal.ui.api.dashboard.BaseLazyLoadingWidget;
import de.cuioss.uimodel.nameprovider.DisplayName;
import de.cuioss.uimodel.nameprovider.LabeledKey;
import de.cuioss.uimodel.result.ResultDetail;
import de.cuioss.uimodel.result.ResultObject;
import de.cuioss.uimodel.result.ResultState;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.security.SecureRandom;

@Named
@ViewScoped
@ToString(of = {"content"}, callSuper = true)
@EqualsAndHashCode(of = {"content"}, callSuper = true)
public class WidgetBean extends BaseLazyLoadingWidget<String> {

    @Serial
    private static final long serialVersionUID = 6027808398818076494L;

    private static final SecureRandom random = new SecureRandom();

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
        if (random.nextInt() % 3 != 0) {
            return new ResultObject<>("Test", ResultState.VALID);
        }
        return new ResultObject<>("", ResultState.ERROR, new ResultDetail(new DisplayName("error")), null);
    }

    @Override
    public void handleResult(String result) {
        content = result;
        repeats = random.nextInt() % 5;
    }
}
