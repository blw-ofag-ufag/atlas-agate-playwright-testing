package selectors;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public final class UserDataPageSelectors {

    private UserDataPageSelectors() {}

    //UI text constants
    private static final String HEADER_TEXT = "Benutzerdaten";
    private static final int HEADER_LEVEL = 2;
    private static final String SECTION_PERSONAL_DATA = "Persönliche Daten";
    private static final String SECTION_EMAIL = "E-Mail";
    private static final String SECTION_MOBILE = "Mobiltelefonnummer";
    private static final String SECTION_CONTACT = "Kontaktdaten";
    private static final String CAPTION_TEXT = "Ihre persönliche Daten können";
    private static final String ACTION_EDIT_EMAIL = "E-Mail ändern";
    private static final String ACTION_EDIT_MOBILE = "Mobiltelefonnummer ändern";
    private static final String ACTION_EDIT_CONTACT = "Kontaktdaten ändern";

    //field labels
    public static final String LABEL_SALUTATION = "Anrede";
    public static final String LABEL_NAME = "Vorname und Name";
    public static final String LABEL_BIRTH_YEAR = "Geburtsjahr";
    public static final String LABEL_EMAIL = "E-Mail-Adresse";
    public static final String LABEL_MOBILE = "Mobiltelefonnummer";
    public static final String LABEL_ADDRESS = "Adresse";
    public static final String LABEL_PHONE = "Telefonnummer";
    public static final String LABEL_LANGUAGE = "Korrespondenzsprache";

    //Headings
    public static Locator header(Page page) {
        return page.getByRole(
                AriaRole.HEADING,
                new Page.GetByRoleOptions()
                        .setName(HEADER_TEXT)
                        .setLevel(HEADER_LEVEL)
        );
    }

    public static Locator personalDataHeading(Page page) {
        return page.getByRole(
                AriaRole.HEADING,
                new Page.GetByRoleOptions().setName(SECTION_PERSONAL_DATA)
        );
    }

    public static Locator emailHeading(Page page) {
        return page.getByRole(
                AriaRole.HEADING,
                new Page.GetByRoleOptions().setName(SECTION_EMAIL)
        );
    }

    public static Locator mobileHeading(Page page) {
        return page.getByRole(
                AriaRole.HEADING,
                new Page.GetByRoleOptions().setName(SECTION_MOBILE)
        );
    }

    public static Locator contactHeading(Page page) {
        return page.getByRole(
                AriaRole.HEADING,
                new Page.GetByRoleOptions().setName(SECTION_CONTACT)
        );
    }

    public static Locator caption(Page page) {
        return page.getByText(CAPTION_TEXT);
    }

    //Action links
    public static Locator editEmailLink(Page page) {
        return page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(ACTION_EDIT_EMAIL)
        );
    }

    public static Locator editMobileLink(Page page) {
        return page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(ACTION_EDIT_MOBILE)
        );
    }

    public static Locator editContactLink(Page page) {
        return page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(ACTION_EDIT_CONTACT)
        );
    }

    //dl/dt/dd helpers
    public static Locator dtByExactLabel(Page page, String label) {
        return page.locator("dl.agate-p-data-list dt")
                .getByText(label, new Locator.GetByTextOptions().setExact(true));
    }

    public static Locator ddForDt(Locator dt) {
        return dt.locator("xpath=following-sibling::dd[1]");
    }
}
