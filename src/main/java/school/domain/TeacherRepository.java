package school.domain;

public interface TeacherRepository {
    Teacher getById(Guid guid);
    void save(Teacher teacher);
}
