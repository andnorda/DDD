package experiment;

public class App {
    private static Dispatcher<Command> dispatcher;
    private static DispatcherWithResult<Command, String> dispatcherWithResult;

    public static void Initialize() {
        dispatcher = new Dispatcher<>();
        dispatcher.register(DoBar.class, doBar -> {
            CommandHandlers.Bar(ServiceImpl::new, (DoBar) doBar);
        });

        dispatcherWithResult = new DispatcherWithResult<>();
        dispatcherWithResult.register(DoFoo.class, doFoo -> {
            return CommandHandlers.Foo(new ServiceImpl(), (DoFoo) doFoo);
        });
    }

    public static void main(String[] args) {
        Initialize();
        dispatcher.dispatch(new DoBar());
        String result = dispatcherWithResult.dispatch(new DoFoo());
        System.out.println(result);
    }
}
