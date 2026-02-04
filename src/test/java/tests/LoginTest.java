package tests;

import base.BaseTest;
import config.TestConfig;
import pages.LoginPage;
import pages.LandingPage;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    void runScreenshotTest() {
        TestConfig.validate();

        LoginPage loginPage = new LoginPage(page);
        //LandingPage landingPage = new LandingPage(page); //chatgpt

        loginPage.login(
                TestConfig.LOGIN_EMAIL,
                TestConfig.LOGIN_PASSWORD
        );

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
