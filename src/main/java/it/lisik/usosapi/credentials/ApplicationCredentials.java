package it.lisik.usosapi.credentials;

public class ApplicationCredentials {
    private final String applicationUrl;
    private final String consumerKey;
    private final String secret;

    public ApplicationCredentials(String applicationUrl, String consumerKey, String secret) {
        this.applicationUrl = applicationUrl;
        this.consumerKey = consumerKey;
        this.secret = secret;
    }

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getSecret() {
        return secret;
    }
}
