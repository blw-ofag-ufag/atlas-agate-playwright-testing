package tests;

import base.BaseTest;
import pages.LandingPage;
import testdata.TestUsers;
import workflow.LoginWorkflow;
import model.TestUser;

import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VerifyLandingPage extends BaseTest {

    @Test
    void LandingPageTest() {
        TestUser user = TestUsers.STANDARD_USER;

        new LoginWorkflow(page).loginDefaultUser();
        LandingPage landingPage = new LandingPage(page);
        landingPage.assertPageLoaded();

        landingPage.assertAgateLogoIsAttached();
        landingPage.assertHeaderIsVisible();
        landingPage.assertSubHeaderIsVisible();
        landingPage.assertAgateNumberValueIsVisible();

        landingPage.assertAgateNumberValue(user.agateNumber());

        landingPage.clickUserData();
    }

}
