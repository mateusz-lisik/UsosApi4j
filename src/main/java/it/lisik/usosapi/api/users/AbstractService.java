package it.lisik.usosapi.api.users;

import com.google.api.client.http.HttpRequestFactory;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public abstract class AbstractService {
    protected final HttpRequestFactory requestFactory;
    protected final String applicationUrl;

    @Inject
    public AbstractService(HttpRequestFactory requestFactory, @Named("ApplicationUrl") String applicationUrl) {
        this.requestFactory = requestFactory;
        this.applicationUrl = applicationUrl;
    }
}
