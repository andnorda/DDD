package experiment;

import java.util.function.Supplier;

public class CommandHandlers {
    public static void Bar(Supplier<Service> service, DoBar command) {
        System.out.println("Bar!");
    }
    public static String Foo(Service service, DoFoo command) {
        return "Foo!";
    }
}
