package it.lisik.usosapi.api.courses;

import com.google.api.client.http.HttpRequestFactory;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import it.lisik.usosapi.api.AbstractService;
import it.lisik.usosapi.api.courses.models.CourseEdition;
import it.lisik.usosapi.api.courses.models.CourseEditionsResponse;
import it.lisik.usosapi.api.courses.requests.GetCurrentUserCoursesOrTerms;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CoursesInformationService extends AbstractService {
    @Inject
    public CoursesInformationService(HttpRequestFactory requestFactory, @Named("ApplicationUrl") String applicationUrl) {
        super(requestFactory, applicationUrl);
    }

    public List<CourseEdition> getCourseEditionsListForCurrentUser(boolean activeOnly) throws IOException {
        final List<CourseEdition> courseEditions = new LinkedList<CourseEdition>();
        final CourseEditionsResponse courseEditionsResponse = getCourseEditionsForCurrentUser(activeOnly);
        for (Map.Entry<String, List<CourseEdition>> entry : courseEditionsResponse.getCourseEditions().entrySet()) {
            courseEditions.addAll(entry.getValue());
        }

        return courseEditions;
    }

    public Map<String, List<CourseEdition>> getCourseEditionsMapForCurrentUser(boolean activeOnly) throws IOException {
        return getCourseEditionsForCurrentUser(activeOnly).getCourseEditions();
    }
//
//    public List<Term> getTermsListForCurrentUser(boolean activeOnly) {
//        return null;
//    }

    private CourseEditionsResponse getCourseEditionsForCurrentUser(boolean activeOnly) throws IOException {
        return requestFactory.buildGetRequest(
                new GetCurrentUserCoursesOrTerms(
                        applicationUrl,
                        GetCurrentUserCoursesOrTerms.FieldType.COURSE_EDITIONS,
                        activeOnly
                )
        ).execute().parseAs(CourseEditionsResponse.class);
    }
}
