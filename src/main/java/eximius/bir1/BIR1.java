package eximius.bir1;

public final class BIR1 {
    private static final String TEST_API_KEY = "abcde12345abcde12345";

    public static Connection createNewConnection(final String apiKey) {
        return new ConnectionImpl(apiKey, false);
    }

    public static Connection createNewTestConnection() {
        return new ConnectionImpl(TEST_API_KEY, true);
    }
}