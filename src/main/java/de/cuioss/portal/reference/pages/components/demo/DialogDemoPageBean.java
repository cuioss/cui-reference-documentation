package de.cuioss.portal.reference.pages.components.demo;

import de.cuioss.tools.logging.CuiLogger;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@SuppressWarnings("javadoc")
@Named
@SessionScoped
@EqualsAndHashCode
@ToString
public class DialogDemoPageBean implements Serializable {

    private static final CuiLogger log = new CuiLogger(DialogDemoPageBean.class);

    private static final long serialVersionUID = 3744529779452625817L;

    @Getter
    private boolean renderLazyLoadingDialogContent;

    @Getter
    private boolean lazyLoadingDialogContentAvailable;

    public void showLazyLoadingDialog() {
        renderLazyLoadingDialogContent = true;
    }

    public void hideLazyLoadingDialog() {
        renderLazyLoadingDialogContent = false;
        lazyLoadingDialogContentAvailable = false;
    }

    public void initLazyLoadingDialogContent() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error("Error loading lazy dialog content", e);
            Thread.currentThread().interrupt();
        }
        lazyLoadingDialogContentAvailable = true;
    }
}
