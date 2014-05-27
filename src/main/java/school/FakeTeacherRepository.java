package school;

import school.domain.Guid;
import school.domain.Teacher;
import school.domain.TeacherRepository;

import java.util.HashMap;
import java.util.Map;

public class FakeTeacherRepository implements TeacherRepository {
    private Map<Guid, Teacher> teachers = new HashMap<>();

    @Override
    public Teacher getById(Guid guid) {
        return teachers.get(guid);
    }

    @Override
    public void save(Teacher teacher) {
        teachers.put(teacher.getGuid(), teacher);
    }
}
