package tests;

import base.BaseTest;
import model.TestUser;
import testdata.TestUsers;
import pages.LandingPage;
import pages.UserDataPage;
import workflow.LoginWorkflow;

import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VerifyUserData extends BaseTest {

    @Test
    void VerifyUserDataTest() {
        new LoginWorkflow(page).loginDefaultUser();

        LandingPage landingPage = new LandingPage(page);
        landingPage.clickUserData();

        UserDataPage userDataPage = new UserDataPage(page);
        userDataPage.assertPageLoaded();

        TestUser user = TestUsers.STANDARD_USER;
        userDataPage.assertUserData(user);

    }
}