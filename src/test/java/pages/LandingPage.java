package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import selectors.LandingPageSelectors;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LandingPage {

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

        this.agateLogo = LandingPageSelectors.agateLogo(page);
        this.header = LandingPageSelectors.header(page);
        this.caption = LandingPageSelectors.caption(page);
        this.appTest = LandingPageSelectors.appTest(page);
        this.appTest1 = LandingPageSelectors.appTest1(page);
        this.testuserLabel = LandingPageSelectors.testuserLabel(page);
        this.agateNumberLabel = LandingPageSelectors.agateNumberLabel(page);
        this.agateNumberValue = LandingPageSelectors.agateNumberValue(page);
        this.userDataLink = LandingPageSelectors.userDataLink(page);
        this.privacyLink = LandingPageSelectors.privacyLink(page);
        this.passwordSettingsLink = LandingPageSelectors.passwordSettingsLink(page);
        this.logoutLink = LandingPageSelectors.logoutLink(page);
        this.applicationsAgateLink = LandingPageSelectors.applicationsAgateLink(page);
        this.faqLink = LandingPageSelectors.faqLink(page);
        this.supportLink = LandingPageSelectors.supportLink(page);
        this.moreAccessLink = LandingPageSelectors.moreAccessLink(page);
        this.createLoginLink = LandingPageSelectors.createLoginLink(page);
    }

    //assertions
    public void assertAgateLogoIsAttached() {
        assertThat(agateLogo).isAttached();
    }

    public void assertHeaderIsVisible() {
        assertThat(header).isVisible();
    }

    public void assertSubHeaderIsVisible() {
        assertThat(caption).isVisible();
    }

    public void assertAppTestIsVisible() {
        assertThat(appTest).isVisible();
    }

    public void assertAppTest1IsVisible() {
        assertThat(appTest1).isVisible();
    }

    public void assertTesterLabelIsVisible() {
        assertThat(testuserLabel).isAttached();
    }

    public void assertAgateNumberLabelIsVisible() {
        assertThat(agateNumberLabel).isVisible();
    }

    public void assertAgateNumberValueIsVisible() {
        assertThat(agateNumberValue).isVisible();
    }

    public void assertAgateNumberValue(String expectedNumber) {
        assertThat(agateNumberValue).containsText(expectedNumber);
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

    //actions
    public void clickLogo() {
        agateLogo.click();
    }

    public void clickUserData() {
        userDataLink.click();
    }

    public void clickPrivacy() {
        privacyLink.click();
    }

    public void clickPasswordSettings() {
        passwordSettingsLink.click();
    }

    public void clickLogout() {
        logoutLink.click();
    }

    public void clickApplicationsAgate() {
        applicationsAgateLink.click();
    }

    public void clickFaq() {
        faqLink.click();
    }

    public void clickSupport() {
        supportLink.click();
    }

    public void clickMoreAccess() {
        moreAccessLink.click();
    }

    public void clickCreateLogin() {
        createLoginLink.click();
    }
}
