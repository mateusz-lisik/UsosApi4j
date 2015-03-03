package it.lisik.usosapi.api.users.requests;

import com.google.api.client.util.Key;

public class GetUserRequestUrl extends GetSelfUserRequestUrl {
    @Key
    private Long userId;

    public GetUserRequestUrl(String applicationUrl) {
        super(applicationUrl);
    }
}
