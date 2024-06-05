package de.cuioss.portal.reference.portal.navigation.items.portal;

import de.cuioss.jsf.api.application.navigation.NavigationUtils;
import de.cuioss.jsf.api.components.model.menu.NavigationMenuItemSingleImpl;
import jakarta.faces.context.FacesContext;
import lombok.EqualsAndHashCode;

/**
 * Base class for Portal-menue-Items The assumption is, that
 * {@link #getOutcome()} represents a view (implicit navigation). If so the
 * {@link #isActive()} uses this information, to determine whether the current
 * view is active.
 *
 * @author Oliver Wolff
 */
@EqualsAndHashCode(callSuper = true)
public class PortalBaseMenuItem extends NavigationMenuItemSingleImpl {

    private static final long serialVersionUID = -4707337520204816491L;

    @SuppressWarnings("javadoc")
    public PortalBaseMenuItem(Integer order) {
        super(order);
    }

    @Override
    public boolean isActive() {
        return NavigationUtils.getCurrentView(FacesContext.getCurrentInstance()).getViewId().contains(getOutcome());
    }
}
