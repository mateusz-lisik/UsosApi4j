package it.lisik.usosapi.api.grades;

import com.google.api.client.http.HttpRequestFactory;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import it.lisik.usosapi.api.AbstractService;
import it.lisik.usosapi.api.grades.models.CourseEditionGrades;
import it.lisik.usosapi.api.grades.requests.GetGradesFromCourseEditionRequest;

import java.io.IOException;

public class GradesInformationService extends AbstractService {
    @Inject
    public GradesInformationService(HttpRequestFactory requestFactory, @Named("ApplicationUrl") String applicationUrl) {
        super(requestFactory, applicationUrl);
    }

    public CourseEditionGrades getGradesFromCourseEdition(String courseId, String termId) throws IOException {
        return requestFactory.buildGetRequest(
                new GetGradesFromCourseEditionRequest(applicationUrl, courseId, termId)
        ).execute().parseAs(CourseEditionGrades.class);
    }
}
