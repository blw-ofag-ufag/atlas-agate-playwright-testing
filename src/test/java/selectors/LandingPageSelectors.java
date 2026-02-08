package selectors;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public final class LandingPageSelectors {

    private LandingPageSelectors() {}

    //UI text constants
    private static final String AGATE_LOGO_NAME = "Agate Logo. Link zu Startseite";

    private static final String HEADER_TEXT = "Anwendungen";
    private static final int HEADER_LEVEL = 2;

    private static final String CAPTION_TEXT = "Sie haben Zugriff auf";

    private static final String APPTEST_LINK = "Tierverkehr TVD Test";
    private static final String APPTEST_LINK1 = "Tierverkehr TVD Test3";

    private static final String TESTUSER_LABEL = "Testuser Atlas";

    private static final String AGATE_NUMBER_LABEL = "Agate-Nummer";
    private static final Pattern AGATE_NUMBER_VALUE_PATTERN =
            Pattern.compile("Agate-Nummer:\\s*\\d+");

    private static final String LINK_USERDATA = "Benutzerdaten Agate";
    private static final String LINK_PRIVACY = "Datenschutz";
    private static final String LINK_PW_SETTINGS = "Passwort ändern/Einstellungen";
    private static final String LINK_LOGOUT = "Abmelden";

    private static final String LINK_APPS_AGATE = "Anwendungen Agate";
    private static final String LINK_SUPPORT = "Support";
    private static final String LINK_MORE_ACCESS = "Zugriff auf weitere";
    private static final String LINK_CREATE_LOGIN = "Neuen Agate-Login erstellen";
    private static final String LINK_FAQ = "Häufige Fragen";
    private static final String FAQ_HREF = "https://www.blw.admin.ch/de/fragen-und-antworten";

    // ---------- Locator factories ----------
    public static Locator agateLogo(Page page) {
        return page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(AGATE_LOGO_NAME)
        );
    }

    public static Locator header(Page page) {
        return page.getByRole(
                AriaRole.HEADING,
                new Page.GetByRoleOptions()
                        .setName(HEADER_TEXT)
                        .setLevel(HEADER_LEVEL)
        );
    }

    public static Locator caption(Page page) {
        return page.getByText(CAPTION_TEXT);
    }

    public static Locator appTest(Page page) {
        return page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName(APPTEST_LINK)
                        .setExact(true)
        );
    }

    public static Locator appTest1(Page page) {
        return page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName(APPTEST_LINK1)
                        .setExact(true)
        );
    }

    public static Locator testuserLabel(Page page) {
        return page.getByText(TESTUSER_LABEL);
    }

    public static Locator agateNumberLabel(Page page) {
        return page.getByText(
                AGATE_NUMBER_LABEL,
                new Page.GetByTextOptions().setExact(false)
        );
    }

    public static Locator agateNumberValue(Page page) {
        return page.getByText(AGATE_NUMBER_VALUE_PATTERN);
    }

    public static Locator userDataLink(Page page) {
        return page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(LINK_USERDATA)
        );
    }

    public static Locator privacyLink(Page page) {
        return page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(LINK_PRIVACY)
        );
    }

    public static Locator passwordSettingsLink(Page page) {
        return page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(LINK_PW_SETTINGS)
        );
    }

    public static Locator logoutLink(Page page) {
        return page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(LINK_LOGOUT)
        );
    }

    public static Locator applicationsAgateLink(Page page) {
        return page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(LINK_APPS_AGATE)
        );
    }

    public static Locator supportLink(Page page) {
        return page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(LINK_SUPPORT)
        );
    }

    public static Locator moreAccessLink(Page page) {
        return page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(LINK_MORE_ACCESS)
        );
    }

    public static Locator createLoginLink(Page page) {
        return page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(LINK_CREATE_LOGIN)
        );
    }

    public static Locator faqLink(Page page) {
        return page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(LINK_FAQ)
        ).and(page.locator("a[href='" + FAQ_HREF + "']"));
    }
}
