package de.cuioss.portal.reference.pages.components.demo;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Named
@RequestScoped
@ToString
@EqualsAndHashCode
public class BlockElementBean implements Serializable {

    private static final long serialVersionUID = -705988438108533133L;

    public String action() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return null;
    }

}
