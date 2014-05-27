package school;

import org.junit.Before;
import org.junit.Test;
import school.applicationServices.AssignTeacherToCourseHandler;
import school.applicationServices.commands.AssignTeacherToCourseCommand;
import school.domain.*;

import static org.junit.Assert.assertFalse;

public class AssignTeacherToCourseTest {

    TeacherRepository teacherRepository;
    CourseRepository courseRepository;

    @Before
    public void setUp() {
        teacherRepository = new FakeTeacherRepository();
        courseRepository = new FakeCourseRepository();
    }

    @Test
    public void shouldNotBeFull_WhenTeacherHasBeenAssigned() {
        // Given
        Guid courseId = new Guid(1);
        Course course = new Course(courseId);
        courseRepository.save(course);

        Guid teacherId = new Guid(2);
        int studentLimit = 1;
        Teacher teacher = new Teacher(teacherId, studentLimit);
        teacherRepository.save(teacher);
        AssignTeacherToCourseCommand assignTeacherToCourseCommand = new AssignTeacherToCourseCommand(teacherId, courseId);

        // When
        AssignTeacherToCourseHandler.handle(teacherRepository, courseRepository, assignTeacherToCourseCommand);

        // Then
        assertFalse(course.isFull());
    }
}
