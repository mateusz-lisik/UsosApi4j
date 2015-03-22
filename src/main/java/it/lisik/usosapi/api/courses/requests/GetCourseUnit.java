package it.lisik.usosapi.api.courses.requests;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;

public class GetCourseUnit extends GenericUrl {
    private static final String SERVICE_URL = "services/courses/unit";
    @Key("unit_id")
    private String unitId;

    @Key
    private final String fields = "id|course_name|course_id|term_id|homepage_url|profile_url|classtype_id|" +
            "learning_outcomes|assessment_criteria|topics|teaching_methods|bibliography";

    public GetCourseUnit(String applicationUrl, String unitId) {
        super(applicationUrl + SERVICE_URL);
        this.unitId = unitId;
    }
}
