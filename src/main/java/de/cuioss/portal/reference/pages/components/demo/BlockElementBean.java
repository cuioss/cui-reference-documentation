package de.cuioss.portal.reference.pages.components.demo;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import lombok.EqualsAndHashCode;
import lombok.ToString;

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
