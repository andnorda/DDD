package school.applicationServices;

import school.applicationServices.commands.CreateStudentCommand;
import school.domain.Student;
import school.domain.StudentRepository;

public class CreateStudentHandler {
    public static void handle(StudentRepository repository, CreateStudentCommand command) {
        repository.save(new Student(command.getGuid()));
    }
}
