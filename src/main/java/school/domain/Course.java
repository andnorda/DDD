package school.domain;

public class Course {
    private Guid guid;
    private int studentLimit = -1;
    private int currentNumberOfStudents = 0;

    public Course(Guid guid) {
        this.guid = guid;
    }

    public Guid getGuid() {
        return guid;
    }

    public boolean isFull() {
        return studentLimit <= currentNumberOfStudents;
    }

    public void assignTeacher(Teacher teacher) {
        studentLimit = teacher.getStudentLimit();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        if (!guid.equals(course.guid)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return guid.hashCode();
    }

    public void populateNumberOfStudents(StudentRepository studentRepository) {
        currentNumberOfStudents = studentRepository.getNumberOfStudentsInCourse(this);
    }
}
