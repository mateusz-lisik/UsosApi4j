package it.lisik.usosapi.api.users;

import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.json.GenericJson;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import it.lisik.usosapi.api.AbstractService;
import it.lisik.usosapi.api.users.models.PhotoSize;
import it.lisik.usosapi.api.users.models.User;
import it.lisik.usosapi.api.users.requests.GetSelfUserRequestUrl;
import it.lisik.usosapi.api.users.requests.GetUserRequestUrl;

import java.io.IOException;
import java.util.Map;

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

    /**
     * Gets url of user photo of given size.
     * <b>This is short-lived url, do not reuse it. You should download it or regenerate before using it.</b>
     * @param size desired size of photo
     * @return url of photo
     */
    public String getCurrentUserPhotoUrl(PhotoSize size) throws IOException {
        final String fieldName = String.format("photo_urls[%s]", size.getDimensions());
        final GenericJson json = requestFactory.buildGetRequest(
                new GetSelfUserRequestUrl(applicationUrl, fieldName)
        ).execute().parseAs(GenericJson.class);
        final Map photoUrls = (Map) json.get("photo_urls");
        return (String) photoUrls.get(size.getDimensions());
    }
}
