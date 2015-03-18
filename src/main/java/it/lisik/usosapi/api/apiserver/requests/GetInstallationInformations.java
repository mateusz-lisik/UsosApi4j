package it.lisik.usosapi.api.apiserver.requests;

import com.google.api.client.http.GenericUrl;

public class GetInstallationInformations extends GenericUrl {
    public static final String SERVICE_URL = "services/apisrv/installations";

    public GetInstallationInformations(String applicationUrl) {
        super(applicationUrl + SERVICE_URL);
    }
}
