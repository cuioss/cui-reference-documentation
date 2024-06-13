@Dependent
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PreferencesMenuItem extends PortalNavigationMenuItemSingleImpl {

    @Serial
    private static final long serialVersionUID = 1452093785009425867L;

    /**
     * The label Key for this component.
     */
    public static final String LABEL_KEY = "cui.commons.portal.menu.preferences.label";

    /**
     * The title Key for this component.
     */
    public static final String TITLE_KEY = "cui.commons.portal.menu.preferences.title";

    /**
     * The icon for this component.
     */
    public static final String ICON = "cui-icon-settings";

    /**
     * The string based id for this menu item.
     */
    public static final String MENU_ID = "preferencesMenuItem";

    /**
     * Constructor.
     */
    public PreferencesMenuItem() {
        super.setIconStyleClass(ICON);
        super.setId(MENU_ID);
        super.setLabelKey(LABEL_KEY);
        super.setTitleKey(TITLE_KEY);
        super.setOutcome(PreferencesPage.OUTCOME);
    }
}
