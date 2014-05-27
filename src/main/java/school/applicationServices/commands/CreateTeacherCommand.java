package school.applicationServices.commands;

import school.domain.Guid;

public class CreateTeacherCommand {
    private Guid guid;
    private int studentLimit;

    public CreateTeacherCommand(Guid guid, int studentLimit) {
        this.guid = guid;
        this.studentLimit = studentLimit;
    }

    public Guid getGuid() {
        return guid;
    }

    public int getStudentLimit() {
        return studentLimit;
    }
}
