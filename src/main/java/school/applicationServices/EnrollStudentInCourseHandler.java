package school.applicationServices;

import school.applicationServices.commands.EnrollStudentInCourseCommand;
import school.domain.*;

public class EnrollStudentInCourseHandler {
    public static void handle(StudentRepository studentRepository, CourseRepository courseRepository, EnrollStudentInCourseCommand command) throws CourseFullException, DuplicateCourseException {
        Course course = courseRepository.getById(command.getCourseId());
        course.populateNumberOfStudents(studentRepository);
        if (course.isFull()) {
            throw new CourseFullException();
        }

        Student student = studentRepository.getById(command.getStudentId());
        student.enrollIn(course);
    }
}
