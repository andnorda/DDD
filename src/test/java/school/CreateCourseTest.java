package school;

import org.junit.Before;
import org.junit.Test;
import school.applicationServices.CreateCourseHandler;
import school.applicationServices.commands.CreateCourseCommand;
import school.domain.Course;
import school.domain.CourseRepository;
import school.domain.Guid;

import static org.junit.Assert.assertEquals;

public class CreateCourseTest {

    private CourseRepository courseRepository;

    @Before
    public void setUp() {
        courseRepository = new FakeCourseRepository();
    }

    @Test
    public void shouldCreateTeacher() {
        // Given
        Guid guid = new Guid(1);
        Course course = new Course(guid);

        // When
        CreateCourseHandler.handle(courseRepository, new CreateCourseCommand(guid));

        // Then
        assertEquals(course, courseRepository.getById(guid));
    }
}
