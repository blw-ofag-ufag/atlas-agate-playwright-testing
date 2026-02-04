package testdata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.TestUser;

import java.io.InputStream;
import java.util.Map;

public final class TestUsers {

    private TestUsers() {} // no instances

    public static final TestUser STANDARD_USER =
            new TestUser(
                    new TestUser.Personal(
                            "Frau",
                            "Testuser Atlas",
                            "2026"
                    ),
                    new TestUser.Contact(
                            "testuser.atlas@example.com",
                            "(nicht angegeben)",
                            "Schwarzenburgstrasse 165\n3003 Bern",
                            "",
                            "Deutsch"
                    )
            );
}
