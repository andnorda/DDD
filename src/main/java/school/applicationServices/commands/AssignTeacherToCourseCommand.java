package school.applicationServices.commands;

import school.domain.Guid;

public class AssignTeacherToCourseCommand {
    private Guid teacherId;
    private Guid courseId;

    public AssignTeacherToCourseCommand(Guid teacherId, Guid courseId) {
        this.teacherId = teacherId;
        this.courseId = courseId;
    }

    public Guid getTeacherId() {
        return teacherId;
    }

    public Guid getCourseId() {
        return courseId;
    }
}
