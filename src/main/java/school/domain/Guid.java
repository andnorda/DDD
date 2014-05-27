package school.domain;

public class Guid {

    private final int id;

    public Guid(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guid)) return false;

        Guid guid = (Guid) o;

        if (id != guid.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
