package it.lisik.usosapi.injectors;

import com.google.inject.AbstractModule;
import it.lisik.usosapi.UsosClient;

public class ClientModule extends AbstractModule {
    private final UsosClient client;

    public ClientModule(UsosClient client) {
        this.client = client;
    }

    protected void configure() {
        bind(UsosClient.class).toInstance(client);
    }
}
