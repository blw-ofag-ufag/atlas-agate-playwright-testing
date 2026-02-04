package tests;

import base.BaseTest;
import pages.LandingPage;
import workflow.LoginWorkflow;


import com.microsoft.playwright.Page;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    void LoginTest() {
        new LoginWorkflow(page).loginDefaultUser();


        LandingPage landingPage = new LandingPage(page);

        landingPage.assertPageLoaded();

        //gezielte Assertions
        landingPage.assertAgateLogoIsAttached();
        landingPage.assertHeaderIsVisible();
        landingPage.assertSubHeaderIsVisible();
        landingPage.assertAgateNumberValueIsVisible();

        landingPage.clickUserData();




        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")).setFullPage(true)
        );
    }
}
