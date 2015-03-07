/*
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 02.03.2015
 * Time: 21:41
 */
package it.lisik.usosapi.injectors;

import com.google.api.client.auth.oauth.OAuthParameters;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import it.lisik.usosapi.errorhandler.ApiResponseErrorHandler;

import java.io.IOException;

public class OAuthModule extends AbstractModule {
    private final String baseUrl;
    private final OAuthParameters oAuthParameters;

    public OAuthModule(String baseUrl, OAuthParameters oAuthParameters) {
        super();
        this.baseUrl = baseUrl;
        this.oAuthParameters = oAuthParameters;
    }

    protected void configure() {
        bind(String.class).annotatedWith(Names.named("ApplicationUrl")).toInstance(baseUrl);
    }

    @Provides
    @Singleton
    public HttpRequestFactory provideHttpRequestFactory() {
        return new NetHttpTransport().createRequestFactory(
                new HttpRequestInitializer() {
                    @Override
                    public void initialize(HttpRequest request) throws IOException {
                        request.setInterceptor(oAuthParameters);
                        request.setParser(new JsonObjectParser(new JacksonFactory()));
                        request.setUnsuccessfulResponseHandler(new ApiResponseErrorHandler());
                    }
                }
        );
    }
}
