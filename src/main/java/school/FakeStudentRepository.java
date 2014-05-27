package school;

import school.domain.Course;
import school.domain.Guid;
import school.domain.Student;
import school.domain.StudentRepository;

import java.util.HashMap;
import java.util.Map;

public class FakeStudentRepository implements StudentRepository {
    private Map<Guid, Student> students = new HashMap<>();

    @Override
    public Student getById(Guid guid) {
        return students.get(guid);
    }

    @Override
    public void save(Student student) {
        students.put(student.getGuid(), student);
    }

    @Override
    public int getNumberOfStudentsInCourse(Course course) {
        int count = 0;
        for (Student student : students.values()) {
            if (student.isInCourse(course)) {
                count++;
            }
        }
        return count;
    }
}
