package it.lisik.usosapi.api.users.user.requests;

import com.google.api.client.util.Key;

public class GetUserRequestUrl extends GetSelfUserRequestUrl {
    @Key("user_id")
    private String userId;

    public GetUserRequestUrl(String applicationUrl, Long userId) {
        super(applicationUrl);
        this.userId = String.valueOf(userId);
    }
}
