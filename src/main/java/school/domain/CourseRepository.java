package school.domain;

public interface CourseRepository {
    void save(Course course);
    Course getById(Guid guid);
}
