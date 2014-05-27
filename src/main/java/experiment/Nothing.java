package experiment;

public class Nothing {

    private Nothing() { }

    public static final Nothing Value = new Nothing();

    @Override
    public String toString()
    {
        return "Nothing";
    }
}
