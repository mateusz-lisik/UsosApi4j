package it.lisik.usosapi.api;

import com.google.api.client.http.HttpRequestFactory;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import it.lisik.usosapi.UsosClient;

public abstract class AbstractService {
    protected final HttpRequestFactory requestFactory;
    protected final String applicationUrl;
    protected final UsosClient client;

    @Inject
    public AbstractService(HttpRequestFactory requestFactory, @Named("ApplicationUrl") String applicationUrl, UsosClient client) {
        this.requestFactory = requestFactory;
        this.applicationUrl = applicationUrl;
        this.client = client;
    }

    @Inject
    public AbstractService(HttpRequestFactory requestFactory, @Named("ApplicationUrl") String applicationUrl) {
        this(requestFactory, applicationUrl, null);
    }
}
