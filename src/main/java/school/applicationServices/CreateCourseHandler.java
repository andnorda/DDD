package school.applicationServices;

import school.applicationServices.commands.CreateCourseCommand;
import school.domain.Course;
import school.domain.CourseRepository;

public class CreateCourseHandler {
    public static void handle(CourseRepository repository, CreateCourseCommand command) {
        repository.save(new Course(command.geGuid()));
    }
}
