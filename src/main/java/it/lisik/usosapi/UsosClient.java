package it.lisik.usosapi;

import com.google.api.client.auth.oauth.OAuthHmacSigner;
import com.google.api.client.auth.oauth.OAuthParameters;
import com.google.inject.Guice;
import com.google.inject.Injector;
import it.lisik.usosapi.api.courses.CoursesInformationService;
import it.lisik.usosapi.credentials.ApplicationCredentials;
import it.lisik.usosapi.credentials.UserCredentials;
import it.lisik.usosapi.injectors.OAuthModule;
import it.lisik.usosapi.api.users.UserInformationService;

/**
 * Client class for USOS Rest API. Every API call throws Exception that is extending IOException
 */
public class UsosClient {
    private final UserCredentials userCredentials;
    private final ApplicationCredentials applicationCredentials;
    private final OAuthParameters oAuthParameters;
    private final Injector injector;

    public UsosClient(UserCredentials userCredentials, ApplicationCredentials applicationCredentials) {
        this.userCredentials = userCredentials;
        this.applicationCredentials = applicationCredentials;
        this.oAuthParameters = prepareOAuthParameters();
        this.injector = Guice.createInjector(
                new OAuthModule(
                        applicationCredentials.getApplicationUrl(),
                        oAuthParameters
                )
        );
    }

    private OAuthParameters prepareOAuthParameters() {
        OAuthHmacSigner signer = new OAuthHmacSigner();
        OAuthParameters parameters = new OAuthParameters();
        signer.tokenSharedSecret = userCredentials.getSecret();
        signer.clientSharedSecret = applicationCredentials.getSecret();
        parameters.signer = signer;
        parameters.consumerKey = applicationCredentials.getConsumerKey();
        parameters.token = userCredentials.getToken();
        return parameters;
    }

    public UserInformationService getUserInformationService() {
        return injector.getInstance(UserInformationService.class);
    }

    public CoursesInformationService getCoursesInformationService() {
        return injector.getInstance(CoursesInformationService.class);
    }

}
