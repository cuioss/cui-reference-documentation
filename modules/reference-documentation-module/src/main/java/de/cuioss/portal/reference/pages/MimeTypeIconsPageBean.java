package de.cuioss.portal.reference.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import de.cuioss.jsf.bootstrap.icon.MimeTypeIcon;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Oliver Wolff
 */
@Named
@RequestScoped
@ToString
@EqualsAndHashCode
public class MimeTypeIconsPageBean implements Serializable {

    /** serial version UID */
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
