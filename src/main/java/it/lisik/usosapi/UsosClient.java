package it.lisik.usosapi;

import com.google.api.client.auth.oauth.OAuthHmacSigner;
import com.google.api.client.auth.oauth.OAuthParameters;
import com.google.inject.Guice;
import com.google.inject.Injector;
import it.lisik.usosapi.api.apiserver.ApiServerInformationService;
import it.lisik.usosapi.api.courses.CoursesInformationService;
import it.lisik.usosapi.api.users.UserInformationService;
import it.lisik.usosapi.credentials.ApplicationCredentials;
import it.lisik.usosapi.credentials.UserCredentials;
import it.lisik.usosapi.injectors.OAuthModule;

import javax.annotation.Nullable;

public class UsosClient {
    private final UserCredentials userCredentials;
    private final ApplicationCredentials applicationCredentials;
    private final OAuthParameters oAuthParameters;
    private final Injector injector;

    /**
     * <p>
     * Creates USOS Client. {@link UserCredentials} are optional, but only minimal subset of APIs can be called without it.
     * If you try to access such API without {@link UserCredentials}
     * {@link it.lisik.usosapi.errorhandler.exceptions.OAuthUnauthorizedException} will be thrown
     * </p>
     * <p>
     * APIs than don't require UserCredentials are marked as {@link it.lisik.usosapi.api.UserTokenIgnored}
     * Some APIs return more specific information when UserCredentials are provided, those are marked as
     * {@link it.lisik.usosapi.api.UserTokenOptional}
     * </p>
     * Some of APIs can be called without any credentials whatsoever. In such case only thing you need is to provide
     * applicationUrl in {@link it.lisik.usosapi.credentials.ApplicationCredentials} constructor. APIs that support that
     * are annotated with {@link it.lisik.usosapi.api.AnonymousAccess}
     *
     * @param userCredentials        - user credentials obtained via OAuth
     * @param applicationCredentials - Consumer Key and Secret obtained via registration your app in USOS
     */
    public UsosClient(@Nullable UserCredentials userCredentials, ApplicationCredentials applicationCredentials) {
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

    /**
     * These API methods allow you to access information on the USOS API server installation, and also retrieve some
     * basic data on all the other official USOS API installations.
     *
     * @return ApiServerInformationService
     */
    public ApiServerInformationService getApiServerInformationService() {
        return injector.getInstance(ApiServerInformationService.class);
    }
}
