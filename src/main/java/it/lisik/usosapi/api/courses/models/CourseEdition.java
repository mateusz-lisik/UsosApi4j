package it.lisik.usosapi.api.courses.models;

import com.google.api.client.util.Key;
import it.lisik.usosapi.api.commons.TranslatedValue;

public class CourseEdition {
    @Key("course_id")
    private String courseId;

    @Key("term_id")
    private String termId;

    @Key("course_name")
    private TranslatedValue courseName;

    public String getCourseId() {
        return courseId;
    }

    public String getTermId() {
        return termId;
    }

    public TranslatedValue getCourseName() {
        return courseName;
    }
}
