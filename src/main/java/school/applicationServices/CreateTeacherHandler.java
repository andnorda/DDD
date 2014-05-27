package school.applicationServices;

import school.applicationServices.commands.CreateTeacherCommand;
import school.domain.Teacher;
import school.domain.TeacherRepository;

public class CreateTeacherHandler {
    public static void handle(TeacherRepository repository, CreateTeacherCommand command) {
        repository.save(new Teacher(command.getGuid(), command.getStudentLimit()));
    }
}
