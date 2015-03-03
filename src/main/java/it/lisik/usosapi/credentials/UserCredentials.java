package it.lisik.usosapi.credentials;

public class UserCredentials {
    private final String token;
    private final String secret;

    public UserCredentials(String secret, String token) {
        this.secret = secret;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getSecret() {
        return secret;
    }
}
