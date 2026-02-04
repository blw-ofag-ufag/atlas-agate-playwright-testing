package pages;
import model.TestUser;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UserDataPage {

    // UI text constants
    private static final String HEADER_TEXT = "Benutzerdaten";

    private static final String SECTION_PERSONAL_DATA = "Persönliche Daten";
    private static final String SECTION_EMAIL = "E-Mail";
    private static final String SECTION_MOBILE = "Mobiltelefonnummer";
    private static final String SECTION_CONTACT = "Kontaktdaten";
    private static final String CAPTION_TEXT = "Ihre persönliche Daten können";

    private static final String ACTION_EDIT_EMAIL = "E-Mail ändern";
    private static final String ACTION_EDIT_MOBILE = "Mobiltelefonnummer ändern";
    private static final String ACTION_EDIT_CONTACT = "Kontaktdaten ändern";

    private static final int HEADER_LEVEL = 2;

    // field labels
    private static final String LABEL_SALUTATION = "Anrede";
    private static final String LABEL_NAME = "Vorname und Name";
    private static final String LABEL_BIRTH_YEAR = "Geburtsjahr";
    private static final String LABEL_EMAIL = "E-Mail-Adresse";
    private static final String LABEL_MOBILE = "Mobiltelefonnummer";
    private static final String LABEL_ADRESS = "Adresse";
    private static final String LABEL_PHONE = "Telefonnummer";
    private static final String LABEL_LANGUAGE = "Korrespondenzsprache";
    private final Page page;

    // Headings
    private final Locator header;
    private final Locator personalDataHeading;
    private final Locator emailHeading;
    private final Locator mobileHeading;
    private final Locator contactHeading;
    private final Locator caption;


    // Actions
    private final Locator editEmailLink;
    private final Locator editMobileLink;
    private final Locator editContactLink;


    public UserDataPage(Page page) {
        this.page = page;

        // Main page header
        this.header = page.getByRole(
                AriaRole.HEADING,
                new Page.GetByRoleOptions()
                        .setName(HEADER_TEXT)
                        .setLevel(HEADER_LEVEL)
        );

        // Section headings
        this.personalDataHeading = page.getByRole(
                AriaRole.HEADING,
                new Page.GetByRoleOptions().setName(SECTION_PERSONAL_DATA)
        );

        this.emailHeading = page.getByRole(
                AriaRole.HEADING,
                new Page.GetByRoleOptions().setName(SECTION_EMAIL)
        );

        this.mobileHeading = page.getByRole(
                AriaRole.HEADING,
                new Page.GetByRoleOptions().setName(SECTION_MOBILE)
        );

        this.contactHeading = page.getByRole(
                AriaRole.HEADING,
                new Page.GetByRoleOptions().setName(SECTION_CONTACT)
        );

        this.caption = page.getByText(CAPTION_TEXT);

        // Action links (role-based)
        this.editEmailLink = page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(ACTION_EDIT_EMAIL)
        );

        this.editMobileLink = page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(ACTION_EDIT_MOBILE)
        );

        this.editContactLink = page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(ACTION_EDIT_CONTACT)
        );
    }

    // --- assertions ---
    public void assertHeaderIsVisible() { assertThat(header).isVisible(); }

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

    //helper method for personal data assertions
    private void assertFieldValue(String label, String expectedValue) {
        Locator row = page.getByText(
                label,
                new Page.GetByTextOptions().setExact(true)
        ).locator("..");

        assertThat(row).containsText(expectedValue);
    }

    public void assertPersonalDataSection(String salutation, String fullName, String birthYear) {
        assertFieldValue(LABEL_SALUTATION, salutation);
        assertFieldValue(LABEL_NAME, fullName);
        assertFieldValue(LABEL_BIRTH_YEAR, birthYear);
    }

    public void assertContactSection(String email, String mobile, String address, String phone, String language) {
        assertFieldValue(LABEL_EMAIL, email);
        assertFieldValue(LABEL_MOBILE, mobile);
        assertFieldValue(LABEL_ADRESS, address);
        assertFieldValue(LABEL_PHONE, phone);
        assertFieldValue(LABEL_LANGUAGE, language);
    }

    public void assertPersonalDataSection(TestUser user) {
        assertPersonalDataSection(
                user.personal().salutation(),
                user.personal().fullName(),
                user.personal().birthYear()
        );
    }

    public void assertContactSection(TestUser user) {
        assertContactSection(
                user.contact().email(),
                user.contact().mobile(),
                user.contact().address(),
                user.contact().phone(),
                user.contact().language()
        );
    }


    //actions (optional)
    public void clickEditEmail() { editEmailLink.click(); }
    public void clickEditMobile() { editMobileLink.click(); }
    public void clickEditContact() { editContactLink.click(); }
}
