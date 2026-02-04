package workflow;

import com.microsoft.playwright.Page;
import config.Credentials;
import pages.LoginPage;

public class LoginWorkflow {

    private final Page page;

    public LoginWorkflow(Page page) {
        this.page = page;
    }

    public void loginDefaultUser() {
        new LoginPage(page).login(Credentials.email(), Credentials.password());
    }
}
