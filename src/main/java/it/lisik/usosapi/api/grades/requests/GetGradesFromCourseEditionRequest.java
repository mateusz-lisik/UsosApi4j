package it.lisik.usosapi.api.grades.requests;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;

public class GetGradesFromCourseEditionRequest extends GenericUrl {
    public final static String SERVICE_URI = "services/grades/course_edition";

    @Key("course_id")
    private final String courseId;

    @Key("term_id")
    private final String termId;

    public GetGradesFromCourseEditionRequest(String applicationUrl, String courseId, String termId) {
        super(applicationUrl + SERVICE_URI);
        this.courseId = courseId;
        this.termId = termId;
    }
}
