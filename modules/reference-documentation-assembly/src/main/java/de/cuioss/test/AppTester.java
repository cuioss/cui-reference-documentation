package de.cuioss.test;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.Application;
import javax.faces.application.ApplicationWrapper;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class AppTester {

    @Inject
    Application application;

    public String getAppClass() {
        StringBuilder builder = new StringBuilder();
        Application current = FacesContext.getCurrentInstance().getApplication();
        ApplicationWrapper wrapper;
        while (current instanceof ApplicationWrapper) {
            wrapper = (ApplicationWrapper) current;
            System.out.println(wrapper.getClass().getName());
            current = wrapper.getWrapped();
        }
        System.out.println(application.getELResolver().getClass());
        return getUnproxiedClass(application.getClass()).getName();
    }

    public void action(ActionEvent actionEvent) {
        final var navigationHandler = application.getNavigationHandler();

        if (navigationHandler instanceof ConfigurableNavigationHandler con) {

            final var navigationCase = con.getNavigationCase(FacesContext.getCurrentInstance(), null, "support");

            System.out.println(navigationCase);
        }
        throw new IllegalStateException("boom");
    }

    public static Class getUnproxiedClass(Class currentClass) {
        Class unproxiedClass = currentClass;

        while (isProxiedClass(unproxiedClass)) {
            unproxiedClass = unproxiedClass.getSuperclass();
        }

        return unproxiedClass;
    }

    /**
     * Analyses if the given class is a generated proxy class
     * 
     * @param currentClass current class
     * @return true if the given class is a known proxy class, false otherwise
     */
    public static boolean isProxiedClass(Class currentClass) {
        if ((currentClass == null) || (currentClass.getSuperclass() == null)) {
            return false;
        }

        String name = currentClass.getName();
        return name.startsWith(currentClass.getSuperclass().getName()) && (name.contains("$$") // CDI
                || name.contains("_ClientProxy") // Quarkus
                || name.contains("$HibernateProxy$")); // Hibernate
    }
}
