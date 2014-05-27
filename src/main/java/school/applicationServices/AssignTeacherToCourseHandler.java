package school.applicationServices;

import school.applicationServices.commands.AssignTeacherToCourseCommand;
import school.domain.Course;
import school.domain.CourseRepository;
import school.domain.Teacher;
import school.domain.TeacherRepository;

public class AssignTeacherToCourseHandler {
    public static void handle(TeacherRepository teacherRepository, CourseRepository courseRepository, AssignTeacherToCourseCommand command) {
        Teacher teacher = teacherRepository.getById(command.getTeacherId());
        Course course = courseRepository.getById(command.getCourseId());
        course.assignTeacher(teacher);
    }
}
