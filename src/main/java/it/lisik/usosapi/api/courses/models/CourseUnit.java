package it.lisik.usosapi.api.courses.models;

import com.google.api.client.util.Key;
import it.lisik.usosapi.api.commons.TranslatedValue;

import java.util.List;

public class CourseUnit {
    @Key
    private Integer id;

    @Key("course_name")
    private TranslatedValue courseName;

    @Key("course_id")
    private String courseId;

    @Key("term_id")
    private String termId;

    @Key("homepage_url")
    private String homepageUrl;

    @Key("profile_url")
    private List<String> profileUrl;

    @Key("classtype_id")
    private String classtypeId;

    @Key("learning_outcomes")
    private TranslatedValue learningOutcomes;

    @Key("assessment_criteria")
    private TranslatedValue assessmentCriteria;

    @Key
    private TranslatedValue topics;

    @Key("teaching_methods")
    private TranslatedValue teachingMethods;

    @Key
    private TranslatedValue bibliography;

    public TranslatedValue getBibliography() {
        return bibliography;
    }

    public TranslatedValue getTeachingMethods() {
        return teachingMethods;
    }

    public TranslatedValue getCourseName() {
        return courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getTermId() {
        return termId;
    }

    public String getHomepageUrl() {
        return homepageUrl;
    }

    public List<String> getProfileUrl() {
        return profileUrl;
    }

    public String getClasstypeId() {
        return classtypeId;
    }

    public TranslatedValue getLearningOutcomes() {
        return learningOutcomes;
    }

    public TranslatedValue getAssessmentCriteria() {
        return assessmentCriteria;
    }

    public TranslatedValue getTopics() {
        return topics;
    }

    public Integer getId() {
        return id;
    }
}
