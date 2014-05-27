package school;

import org.junit.Before;
import org.junit.Test;
import school.applicationServices.CreateStudentHandler;
import school.applicationServices.commands.CreateStudentCommand;
import school.domain.Guid;
import school.domain.Student;
import school.domain.StudentRepository;

import static org.junit.Assert.assertEquals;

public class CreateStudentTest {

    private StudentRepository studentRepository;

    @Before
    public void setUp() {
        studentRepository = new FakeStudentRepository();
    }

    @Test
    public void shouldCreateTeacher() {
        // Given
        Guid guid = new Guid(1);
        Student student = new Student(guid);

        // When
        CreateStudentHandler.handle(studentRepository, new CreateStudentCommand(guid));

        // Then
        assertEquals(student, studentRepository.getById(guid));
    }
}
