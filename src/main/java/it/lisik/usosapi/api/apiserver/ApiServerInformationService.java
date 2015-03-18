package it.lisik.usosapi.api.apiserver;

import com.google.api.client.http.HttpRequestFactory;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import it.lisik.usosapi.api.AbstractService;
import it.lisik.usosapi.api.AnonymousAccess;
import it.lisik.usosapi.api.UserTokenOptional;
import it.lisik.usosapi.api.apiserver.models.ApiConsumerInformation;
import it.lisik.usosapi.api.apiserver.models.InstallationInformation;
import it.lisik.usosapi.api.apiserver.requests.GetApiConsumerInformation;
import it.lisik.usosapi.api.apiserver.requests.GetInstallationInformation;
import it.lisik.usosapi.api.apiserver.requests.GetInstallationInformations;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ApiServerInformationService extends AbstractService {

    @Inject
    public ApiServerInformationService(HttpRequestFactory requestFactory, @Named("ApplicationUrl") String applicationUrl) {
        super(requestFactory, applicationUrl);
    }

    @UserTokenOptional
    public ApiConsumerInformation getApiConsumerInformation() throws IOException {
        return requestFactory.buildGetRequest(
                new GetApiConsumerInformation(applicationUrl)
        ).execute().parseAs(ApiConsumerInformation.class);
    }

    @AnonymousAccess
    public InstallationInformation getInstallationInformation() throws IOException {
        return requestFactory.buildGetRequest(
                new GetInstallationInformation(applicationUrl)
        ).execute().parseAs(InstallationInformation.class);
    }

    @AnonymousAccess
    public List<InstallationInformation> getInstallationsInformation() throws IOException {
        final InstallationInformation[] installationInformations = requestFactory.buildGetRequest(
                new GetInstallationInformations(applicationUrl)
        ).execute().parseAs(InstallationInformation[].class);
        return Arrays.asList(installationInformations);
    }
}
