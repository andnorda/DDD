package school.applicationServices.commands;

import school.domain.Guid;

public class EnrollStudentInCourseCommand {
    private Guid studentId;
    private Guid courseId;

    public EnrollStudentInCourseCommand(Guid studentId, Guid courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public Guid getStudentId() {
        return studentId;
    }

    public Guid getCourseId() {
        return courseId;
    }
}
