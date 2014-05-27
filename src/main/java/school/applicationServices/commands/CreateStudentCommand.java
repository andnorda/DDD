package school.applicationServices.commands;

import school.domain.Guid;

public class CreateStudentCommand {
    private Guid guid;

    public CreateStudentCommand(Guid guid) {
        this.guid = guid;
    }

    public Guid getGuid() {
        return guid;
    }
}
