package it.lisik.usosapi.api.users.user.requests;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;

public class GetSelfUserRequestUrl extends GenericUrl {
    public final static String SERVICE_URI = "/services/users/user";
    @Key
    private String fields = "id|first_name|middle_names|last_name|sex|student_status";

    public GetSelfUserRequestUrl(String applicationUrl) {
        super(applicationUrl + SERVICE_URI);
    }
}
