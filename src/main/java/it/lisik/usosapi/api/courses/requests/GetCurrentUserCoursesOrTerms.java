package it.lisik.usosapi.api.courses.requests;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;

public class GetCurrentUserCoursesOrTerms extends GenericUrl {
    public static final String SERVICE_URL = "/services/courses/user";
    @Key
    private final String fields;
    @Key("active_terms_only")
    private final boolean activeTermsOnly;

    public GetCurrentUserCoursesOrTerms(String applicationUrl, FieldType fieldType, boolean activeTermsOnly) {
        super(applicationUrl + SERVICE_URL);
        this.activeTermsOnly = activeTermsOnly;
        this.fields = fieldType.toString().toLowerCase();
    }

    public enum FieldType {
        COURSE_EDITIONS,
        TERMS
    }
}
