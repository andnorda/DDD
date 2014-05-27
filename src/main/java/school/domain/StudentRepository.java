package school.domain;

public interface StudentRepository {
    Student getById(Guid guid);
    void save(Student student);
    int getNumberOfStudentsInCourse(Course course);
}
