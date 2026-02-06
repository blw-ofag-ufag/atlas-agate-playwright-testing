package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LandingPage {

    // UI text constants
    private static final String AGATE_LOGO_NAME = "Agate Logo. Link zu Startseite";
    private static final String HEADER_TEXT = "Anwendungen";
    private static final String CAPTION_TEXT = "Sie haben Zugriff auf";
    private static final int HEADER_LEVEL = 2;
    private static final String APPTEST_LINK = "Tierverkehr TVD Test";
    private static final String APPTEST_LINK1 = "Tierverkehr TVD Test3";
    private static final String TESTUSER_LABEL = "Testuser Atlas";
    private static final String AGATE_NUMBER_LABEL = "Agate-Nummer";
    private static final String AGATE_NUMBER_VALUE = "Agate-Nummer:\\s*\\d+";
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


    private final Page page;

    private final Locator agateLogo;
    private final Locator header;
    private final Locator caption;
    private final Locator appTest;
    private final Locator appTest1;
    private final Locator testuserLabel;
    private final Locator agateNumberLabel;
    private final Locator agateNumberValue;
    private final Locator userDataLink;
    private final Locator privacyLink;
    private final Locator passwordSettingsLink;
    private final Locator logoutLink;
    private final Locator applicationsAgateLink;
    private final Locator faqLink;
    private final Locator supportLink;
    private final Locator moreAccessLink;
    private final Locator createLoginLink;

    public LandingPage(Page page) {
        this.page = page;

        this.agateLogo = page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(AGATE_LOGO_NAME)
        );

        this.header = page.getByRole(
                AriaRole.HEADING,
                new Page.GetByRoleOptions()
                        .setName(HEADER_TEXT)
                        .setLevel(HEADER_LEVEL)
        );

        this.caption = page.getByText(CAPTION_TEXT);

        this.appTest = page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName(APPTEST_LINK)
                        .setExact(true)
        );

        this.appTest1 = page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName(APPTEST_LINK1)
                        .setExact(true)
        );

        this.testuserLabel = page.getByText(TESTUSER_LABEL);

        this.agateNumberLabel = page.getByText(
                AGATE_NUMBER_LABEL,
                new Page.GetByTextOptions()
                        .setExact(false)
        );

        this.agateNumberValue = page.getByText(Pattern.compile(AGATE_NUMBER_VALUE));

        this.userDataLink = page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().
                        setName(LINK_USERDATA)
        );

        this.privacyLink = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName(LINK_PRIVACY)
        );

        this.passwordSettingsLink = page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName(LINK_PW_SETTINGS)
        );

        this.logoutLink = page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().
                        setName(LINK_LOGOUT)
        );

        this.applicationsAgateLink = page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName(LINK_APPS_AGATE)
        );

        this.supportLink = page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName(LINK_SUPPORT)
        );

        this.moreAccessLink = page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName(LINK_MORE_ACCESS)
        );

        this.createLoginLink = page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName(LINK_CREATE_LOGIN)
        );

        this.faqLink = page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().
                        setName(LINK_FAQ)
        ).and(page.locator("a[href='" + FAQ_HREF + "']"));

    }

    // assertions
    public void assertAgateLogoIsAttached() { assertThat(agateLogo).isAttached(); }
    public void assertHeaderIsVisible() { assertThat(header).isVisible(); }
    public void assertSubHeaderIsVisible() { assertThat(caption).isVisible(); }
    public void assertAppTestIsVisible() { assertThat(appTest).isVisible(); }
    public void assertAppTest1IsVisible() { assertThat(appTest1).isVisible(); }
    public void assertTesterLabelIsVisible() { assertThat(testuserLabel).isAttached(); }
    public void assertAgateNumberLabelIsVisible() { assertThat(agateNumberLabel).isVisible(); }
    public void assertAgateNumberValueIsVisible() { assertThat(agateNumberValue).isVisible(); }

    public void assertAgateNumberValue(String expectedNumber) {
        assertThat(agateNumberValue)
                .containsText(expectedNumber);
    }


    public void assertUserMenuLinksVisible() {
        assertThat(userDataLink).isVisible();
        assertThat(privacyLink).isVisible();
        assertThat(passwordSettingsLink).isVisible();
        assertThat(logoutLink).isVisible();
    }

    public void assertSupportLinksVisible() {
        assertThat(applicationsAgateLink).isVisible();
        assertThat(faqLink).isVisible();
        assertThat(supportLink).isVisible();
        assertThat(moreAccessLink).isVisible();
        assertThat(createLoginLink).isVisible();
    }

    public void assertPageLoaded() {
        assertAgateLogoIsAttached();
        assertHeaderIsVisible();
        assertSubHeaderIsVisible();
        assertAppTestIsVisible();
        assertAppTest1IsVisible();
        assertTesterLabelIsVisible();
        assertAgateNumberLabelIsVisible();
        assertAgateNumberValueIsVisible();
        assertUserMenuLinksVisible();
        assertSupportLinksVisible();
    }

    public void clickLogo() { agateLogo.click(); }

    public void clickUserData() { userDataLink.click(); }
    public void clickPrivacy() { privacyLink.click(); }
    public void clickPasswordSettings() { passwordSettingsLink.click(); }
    public void clickLogout() { logoutLink.click(); }
    public void clickApplicationsAgate() { applicationsAgateLink.click(); }

    public void clickFaq() { faqLink.click(); }
    public void clickSupport() { supportLink.click(); }
    public void clickMoreAccess() { moreAccessLink.click(); }
    public void clickCreateLogin() { createLoginLink.click(); }

}
