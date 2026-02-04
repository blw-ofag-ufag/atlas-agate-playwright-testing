package config;

public class Credentials {

    private static String get(String propName, String envName) {
        String v = System.getProperty(propName);
        if (v != null && !v.isBlank()) return v;

        v = System.getenv(envName);
        if (v != null && !v.isBlank()) return v;

        return "";
    }

    public static String email() {
        return get("loginEmail", "LOGIN_EMAIL");
    }

    public static String password() {
        return get("loginPassword", "LOGIN_PASSWORD");
    }

    public static void validate() {
        if (email().isBlank()) throw new IllegalStateException("LOGIN_EMAIL missing");
        if (password().isBlank()) throw new IllegalStateException("LOGIN_PASSWORD missing");
    }
}
