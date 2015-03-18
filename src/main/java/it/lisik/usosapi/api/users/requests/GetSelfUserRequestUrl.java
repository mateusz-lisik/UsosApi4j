package it.lisik.usosapi.api.users.requests;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;

public class GetSelfUserRequestUrl extends GenericUrl {
    public final static String SERVICE_URI = "services/users/user";
    @Key
    private String fields = "id|first_name|middle_names|last_name|sex|student_status|has_photo";

    public GetSelfUserRequestUrl(String applicationUrl) {
        super(applicationUrl + SERVICE_URI);
    }
    public GetSelfUserRequestUrl(String applicationUrl, String fields) {
        super(applicationUrl + SERVICE_URI);
        this.fields = fields;
    }
}
