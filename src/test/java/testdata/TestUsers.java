package testdata;

import model.TestUser;

public final class TestUsers {

    private TestUsers() {} // no instances

    public static final TestUser STANDARD_USER =
            TestUser.builder()
                    .agateNumber("7569247")
                    .salutation("Frau")
                    .fullName("Testuser Atlas")
                    .birthYear("2026")
                    .email("co.streit@gmail.com")
                    .mobile("(nicht angegeben)")
                    .address("Schwarzenburgstrasse 165\n3003 Bern")
                    .phone("+123456789")
                    .language("Deutsch")
                    .build();

}