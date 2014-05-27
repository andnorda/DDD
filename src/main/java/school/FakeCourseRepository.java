package school;

import school.domain.Course;
import school.domain.CourseRepository;
import school.domain.Guid;

import java.util.HashMap;
import java.util.Map;

public class FakeCourseRepository implements CourseRepository {
    private Map<Guid, Course> courses = new HashMap<>();

    @Override
    public void save(Course course) {
        courses.put(course.getGuid(), course);
    }

    @Override
    public Course getById(Guid guid) {
        return courses.get(guid);
    }
}
