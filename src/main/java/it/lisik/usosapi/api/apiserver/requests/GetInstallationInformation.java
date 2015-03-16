package it.lisik.usosapi.api.apiserver.requests;

import com.google.api.client.http.GenericUrl;

public class GetInstallationInformation extends GenericUrl {
    public static final String SERVICE_URL = "/services/apisrv/installation";

    public GetInstallationInformation(String applicationUrl) {
        super(applicationUrl + SERVICE_URL);
    }
}
