package base;

import com.microsoft.playwright.*;
import config.Credentials;
import config.TestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeEach
    void setUp() {
        TestConfig.validate();
        Credentials.validate();

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        context = browser.newContext(new Browser.NewContextOptions().setBaseURL(TestConfig.BASE_URL));
        page = context.newPage();
    }

    @AfterEach
    void tearDown() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
