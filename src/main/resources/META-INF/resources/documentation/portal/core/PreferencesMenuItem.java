/**
 *
 */
package com.icw.ehf.cui.portal.cdi.api.menu.items;

import com.icw.ehf.cui.portal.cdi.api.menu.PortalMenuItem;
import com.icw.ehf.cui.portal.cdi.api.menu.PortalNavigationMenuItemSingleImpl;
import de.icw.cui.portal.ui.pages.PreferencesPage;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.enterprise.context.Dependent;

/**
 * <p>
 * Default representation of the preferences menu-item. The order is 20. It
 * references {@link UserMenuItem#MENU_ID} as parentId and
 * {@link PreferencesPage#OUTCOME} as outcome.
 * </p>
 *
 * @author Oliver Wolff
 */
@PortalMenuItem
@Dependent
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PreferencesMenuItem extends PortalNavigationMenuItemSingleImpl {

	private static final long serialVersionUID = 1452093785009425867L;

	/** The label Key for this component. */
	public static final String LABEL_KEY = "com.icw.ehf.commons.portal.menu.preferences.label";

	/** The title Key for this component. */
	public static final String TITLE_KEY = "com.icw.ehf.commons.portal.menu.preferences.title";

	/** The icon for this component. */
	public static final String ICON = "cui-icon-settings";

	/** The string based id for this menu item. */
	public static final String MENU_ID = "preferencesMenuItem";

	/**
	 * Constructor.
	 */
	public PreferencesMenuItem() {
		super();
		super.setIconStyleClass(ICON);
		super.setId(MENU_ID);
		super.setLabelKey(LABEL_KEY);
		super.setTitleKey(TITLE_KEY);
		super.setOutcome(PreferencesPage.OUTCOME);
	}
}
