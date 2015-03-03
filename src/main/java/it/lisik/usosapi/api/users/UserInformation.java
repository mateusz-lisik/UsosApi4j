package it.lisik.usosapi.api.users;

import com.google.api.client.http.HttpRequestFactory;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import it.lisik.usosapi.api.users.requests.GetSelfUserRequestUrl;
import it.lisik.usosapi.api.users.user.User;

import java.io.IOException;

public class UserInformation extends AbstractService {

    @Inject
    public UserInformation(HttpRequestFactory requestFactory, @Named("ApplicationUrl") String applicationUrl) {
        super(requestFactory, applicationUrl);
    }

    public User getCurrentUser() {
        try {
            return requestFactory.buildGetRequest(new GetSelfUserRequestUrl(applicationUrl)).execute().parseAs(User.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUser(Long userId) {
        return null;
    }
}
