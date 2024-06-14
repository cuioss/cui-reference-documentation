package de.cuioss.portal.reference.pages;

import de.cuioss.jsf.bootstrap.icon.MimeTypeIcon;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Oliver Wolff
 */
@Named
@RequestScoped
@ToString
@EqualsAndHashCode
public class MimeTypeIconsPageBean implements Serializable {

    /**
     * serial version UID
     */
    @Serial
    private static final long serialVersionUID = -6584517051621040849L;

    @Getter
    private List<MimeTypeIcon> data;

    /**
     * Initializes the mime-types
     */
    @PostConstruct
    public void initData() {
        data = new ArrayList<>(MimeTypeIcon.values().length);
        data.addAll(Arrays.asList(MimeTypeIcon.values()));
    }

}
