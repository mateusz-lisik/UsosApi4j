package it.lisik.usosapi.api.courses.models;

import com.google.api.client.util.Key;

import java.util.List;
import java.util.Map;

public class CourseEditionsResponse {
    @Key("course_editions")
    private Map<String, List<CourseEdition>> courseEditions;

    public Map<String, List<CourseEdition>> getCourseEditions() {
        return courseEditions;
    }
}
