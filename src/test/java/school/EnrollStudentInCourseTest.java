package school;

import org.junit.Before;
import org.junit.Test;
import school.applicationServices.*;
import school.applicationServices.commands.*;
import school.domain.*;

import static org.junit.Assert.fail;

public class EnrollStudentInCourseTest {

    StudentRepository studentRepository;
    CourseRepository courseRepository;
    TeacherRepository teacherRepository;

    @Before
    public void setUp() {
        studentRepository = new FakeStudentRepository();
        courseRepository = new FakeCourseRepository();
        teacherRepository = new FakeTeacherRepository();
    }

    @Test (expected = CourseFullException.class)
    public void shouldThrowException_WhenNoTeacherIsAssigned() throws Exception {
        // Given
        Guid studentId = new Guid(1);
        Student student = new Student(studentId);
        studentRepository.save(student);

        Guid courseId = new Guid(2);
        Course course = new Course(courseId);
        courseRepository.save(course);

        EnrollStudentInCourseCommand enrollStudentInCourseCommand = new EnrollStudentInCourseCommand(studentId, courseId);

        // When
        EnrollStudentInCourseHandler.handle(studentRepository, courseRepository, enrollStudentInCourseCommand);

        // Then an exception is thrown
    }

    @Test (expected = DuplicateCourseException.class)
    public void shouldThrowException_WhenEnrollingToDuplicateCourse() throws Exception {
        // Given
        Guid studentId = new Guid(1);
        Student student = new Student(studentId);
        studentRepository.save(student);

        Guid courseId = new Guid(2);
        Course course = new Course(courseId);
        courseRepository.save(course);

        Guid teacherId = new Guid(3);
        int studentLimit = 10;
        Teacher teacher = new Teacher(teacherId, studentLimit);
        teacherRepository.save(teacher);

        AssignTeacherToCourseCommand assignTeacherToCourseCommand = new AssignTeacherToCourseCommand(teacherId, courseId);
        AssignTeacherToCourseHandler.handle(teacherRepository, courseRepository, assignTeacherToCourseCommand);

        EnrollStudentInCourseCommand enrollStudentInCourseCommand = new EnrollStudentInCourseCommand(studentId, courseId);

        // When
        try {
            EnrollStudentInCourseHandler.handle(studentRepository, courseRepository, enrollStudentInCourseCommand);
        } catch (DuplicateCourseException ex) {
            fail();
        }
        EnrollStudentInCourseHandler.handle(studentRepository, courseRepository, enrollStudentInCourseCommand);

        // Then an exception is thrown
    }

    @Test (expected = CourseFullException.class)
    public void shouldThrowException_WhenEnrollingStudent_GivenFullCourse() throws Exception {
        // Given
        int studentLimit = 1;
        Guid teacherId = new Guid(1);
        CreateTeacherHandler.handle(teacherRepository, new CreateTeacherCommand(teacherId, studentLimit));

        Guid courseId = new Guid(2);
        CreateCourseHandler.handle(courseRepository, new CreateCourseCommand(courseId));
        AssignTeacherToCourseHandler.handle(teacherRepository, courseRepository, new AssignTeacherToCourseCommand(teacherId, courseId));

        Guid studentId1 = new Guid(3);
        CreateStudentHandler.handle(studentRepository, new CreateStudentCommand(studentId1));

        Guid studentId2 = new Guid(4);
        CreateStudentHandler.handle(studentRepository, new CreateStudentCommand(studentId2));

        // When
        try {
            EnrollStudentInCourseHandler.handle(studentRepository, courseRepository, new EnrollStudentInCourseCommand(studentId1, courseId));
        } catch (CourseFullException ex) {
            fail();
        }
        EnrollStudentInCourseHandler.handle(studentRepository, courseRepository, new EnrollStudentInCourseCommand(studentId2, courseId));

        // Then an exception is thrown
    }
}
