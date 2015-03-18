package it.lisik.usosapi.credentials;

import javax.annotation.Nullable;

public class ApplicationCredentials {
    private final String applicationUrl;
    private final String consumerKey;
    private final String secret;

    public ApplicationCredentials(String applicationUrl, @Nullable String consumerKey, @Nullable String secret) {
        if (!applicationUrl.endsWith("/")) {
            applicationUrl = applicationUrl.concat("/");
        }

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
