package school.domain;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private Guid guid;
    private List<Guid> courseIds = new ArrayList<>();

    public Student(Guid guid) {
        this.guid = guid;
    }

    public Guid getGuid() {
        return guid;
    }

    public boolean isInCourse(Course course) {
        return courseIds.contains(course.getGuid());
    }

    public void enrollIn(Course course) throws DuplicateCourseException {
        Guid courseId = course.getGuid();
        if (courseIds.contains(courseId)) {
            throw new DuplicateCourseException();
        }
        courseIds.add(courseId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (!guid.equals(student.guid)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return guid.hashCode();
    }
}
