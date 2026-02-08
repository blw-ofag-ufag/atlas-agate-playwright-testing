package pages;

import model.TestUser;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import selectors.UserDataPageSelectors;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UserDataPage {

    private final Page page;

    //Headings
    private final Locator header;
    private final Locator personalDataHeading;
    private final Locator emailHeading;
    private final Locator mobileHeading;
    private final Locator contactHeading;
    private final Locator caption;

    //Actions
    private final Locator editEmailLink;
    private final Locator editMobileLink;
    private final Locator editContactLink;

    public UserDataPage(Page page) {
        this.page = page;

        //Headings
        this.header = UserDataPageSelectors.header(page);
        this.personalDataHeading = UserDataPageSelectors.personalDataHeading(page);
        this.emailHeading = UserDataPageSelectors.emailHeading(page);
        this.mobileHeading = UserDataPageSelectors.mobileHeading(page);
        this.contactHeading = UserDataPageSelectors.contactHeading(page);
        this.caption = UserDataPageSelectors.caption(page);

        //Actions
        this.editEmailLink = UserDataPageSelectors.editEmailLink(page);
        this.editMobileLink = UserDataPageSelectors.editMobileLink(page);
        this.editContactLink = UserDataPageSelectors.editContactLink(page);
    }

    //assertions
    public void assertHeaderIsVisible() {
        assertThat(header).isVisible();
    }

    public void assertSectionHeadingsVisible() {
        assertThat(personalDataHeading).isVisible();
        assertThat(emailHeading).isVisible();
        assertThat(mobileHeading).isVisible();
        assertThat(contactHeading).isVisible();
        assertThat(caption).isVisible();
    }

    public void assertActionsVisible() {
        assertThat(editEmailLink).isVisible();
        assertThat(editMobileLink).isVisible();
        assertThat(editContactLink).isVisible();
    }

    public void assertHeadersLoaded() {
        assertHeaderIsVisible();
        assertSectionHeadingsVisible();
    }

    public void assertPageLoaded() {
        assertHeadersLoaded();
        assertActionsVisible();
    }

    //field assertions (dl/dt/dd)
    private void assertFieldValue(String label, String expectedValue) {
        Locator dt = UserDataPageSelectors.dtByExactLabel(page, label);
        assertThat(dt).hasCount(1);

        Locator dd = UserDataPageSelectors.ddForDt(dt);
        assertThat(dd).hasText(expectedValue);
    }

    private void assertMultilineAddress(String expectedAddress) {
        Locator dt = UserDataPageSelectors.dtByExactLabel(page, UserDataPageSelectors.LABEL_ADDRESS);
        assertThat(dt).hasCount(1);

        Locator dd = UserDataPageSelectors.ddForDt(dt);

        String[] lines = expectedAddress.split("\\R+");
        for (String line : lines) {
            if (!line.isBlank()) {
                assertThat(dd).containsText(line.trim());
            }
        }
    }

    public void assertUserData(String salutation, String fullName,
                               String birthYear, String email, String mobile,
                               String address, String phone, String language) {

        assertFieldValue(UserDataPageSelectors.LABEL_SALUTATION, salutation);
        assertFieldValue(UserDataPageSelectors.LABEL_NAME, fullName);
        assertFieldValue(UserDataPageSelectors.LABEL_BIRTH_YEAR, birthYear);
        assertFieldValue(UserDataPageSelectors.LABEL_EMAIL, email);
        assertFieldValue(UserDataPageSelectors.LABEL_MOBILE, mobile);
        assertMultilineAddress(address);
        assertFieldValue(UserDataPageSelectors.LABEL_PHONE, phone);
        assertFieldValue(UserDataPageSelectors.LABEL_LANGUAGE, language);
    }

    public void assertUserData(TestUser user) {
        assertUserData(
                user.salutation(),
                user.fullName(),
                user.birthYear(),
                user.email(),
                user.mobile(),
                user.address(),
                user.phone(),
                user.language()
        );
    }

    //actions
    public void clickEditEmail() { editEmailLink.click(); }
    public void clickEditMobile() { editMobileLink.click(); }
    public void clickEditContact() { editContactLink.click(); }
}
