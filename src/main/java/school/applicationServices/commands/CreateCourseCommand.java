package school.applicationServices.commands;

import school.domain.Guid;

public class CreateCourseCommand {
    private Guid guid;

    public CreateCourseCommand(Guid guid) {
        this.guid = guid;
    }

    public Guid geGuid() {
        return guid;
    }
}
