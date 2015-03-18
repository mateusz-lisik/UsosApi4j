package it.lisik.usosapi.api.apiserver.requests;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;

public class GetApiConsumerInformation extends GenericUrl {
    public final static String SERVICE_URL = "services/apisrv/consumer";
    @Key
    private final String fields = "name|url|email|date_registered|administrative_methods|token_scopes";

    public GetApiConsumerInformation(String applicationUrl) {
        super(applicationUrl + SERVICE_URL);
    }
}
