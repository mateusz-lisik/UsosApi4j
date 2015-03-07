package it.lisik.usosapi.api.users;

import com.google.api.client.http.HttpRequestFactory;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import it.lisik.usosapi.api.AbstractService;
import it.lisik.usosapi.api.users.user.User;
import it.lisik.usosapi.api.users.user.requests.*;

import java.io.IOException;

public class UserInformationService extends AbstractService {

    @Inject
    public UserInformationService(HttpRequestFactory requestFactory, @Named("ApplicationUrl") String applicationUrl) {
        super(requestFactory, applicationUrl);
    }

    public User getCurrentUser() throws IOException {
        return requestFactory.buildGetRequest(new GetSelfUserRequestUrl(applicationUrl)).execute().parseAs(User.class);
    }

    public User getUser(Long userId) throws IOException {
        return requestFactory.buildGetRequest(new GetUserRequestUrl(applicationUrl, userId)).execute().parseAs(User.class);
    }
}
