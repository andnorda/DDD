package school;

import org.junit.Before;
import org.junit.Test;
import school.applicationServices.CreateTeacherHandler;
import school.applicationServices.commands.CreateTeacherCommand;
import school.domain.Guid;
import school.domain.Teacher;
import school.domain.TeacherRepository;

import static org.junit.Assert.assertEquals;

public class CreateTeacherTest {

    private TeacherRepository teacherRepository;

    @Before
    public void setUp() {
        teacherRepository = new FakeTeacherRepository();
    }

    @Test
    public void shouldCreateTeacher() {
        // Given
        Guid guid = new Guid(1);
        int studentLimit = 1;
        Teacher teacher = new Teacher(guid, studentLimit);

        // When
        CreateTeacherHandler.handle(teacherRepository, new CreateTeacherCommand(guid, studentLimit));

        // Then
        assertEquals(teacher, teacherRepository.getById(guid));
    }
}
