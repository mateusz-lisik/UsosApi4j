package it.lisik.usosapi.api.grades.models;

import com.google.api.client.util.Key;

import java.util.Map;

public class CourseEditionGrades {
    @Key("course_units_grades")
    private Map<String, Map<String, Grade>> courseUnitGrades;
    @Key("course_grades")
    private Map<String, Grade> courseGrades;

    public Map<String, Map<String, Grade>> getCourseUnitGrades() {
        return courseUnitGrades;
    }

    public Map<String, Grade> getCourseGrades() {
        return courseGrades;
    }
}
