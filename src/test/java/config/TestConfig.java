package config;

public class TestConfig {

    private static String get(String propName, String envName, String defaultValue) {
        String v = System.getProperty(propName);
        if (v != null && !v.isBlank()) return v;

        v = System.getenv(envName);
        if (v != null && !v.isBlank()) return v;

        return defaultValue;
    }

    public static final String ENV =
            get("env", "ENV", "DEV");

    public static final String BASE_URL =
            get("baseUrl", "BASE_URL", "https://idp-rf.agate.ch/IDP/");

    public static void validate() {
        if (BASE_URL.isBlank()) throw new IllegalStateException("BASE_URL missing");
    }
}
