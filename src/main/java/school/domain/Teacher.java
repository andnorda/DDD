package school.domain;

public class Teacher {
    private Guid guid;
    private int studentLimit;

    public Teacher(Guid guid, int studentLimit) {
        this.guid = guid;
        this.studentLimit = studentLimit;
    }

    public Guid getGuid() {
        return guid;
    }

    public int getStudentLimit() {
        return studentLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;

        Teacher teacher = (Teacher) o;

        if (!guid.equals(teacher.guid)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return guid.hashCode();
    }
}
