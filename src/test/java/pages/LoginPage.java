package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.TestConfig;

public class LoginPage {

    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String email, String password) {
        navigate();

        page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Anmelden mit CH-LOGIN")
        ).click();

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions().setName("E-Mail*")
        ).fill(email);

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Weiter")
        ).click();

        page.locator("#isiwebpasswd").fill(password);

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Login")
        ).click();
    }

    private void navigate() {
        page.navigate(TestConfig.BASE_URL);
    }
}
