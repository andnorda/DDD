package experiment;

import java.util.function.Consumer;

public class Dispatcher<TMessage> {

    private DispatcherWithResult<TMessage, String> dispatcherWithResult = new DispatcherWithResult();

    public void register(Class clazz, Consumer<TMessage> consumer) {
        dispatcherWithResult.register(clazz, command -> {
            consumer.accept((TMessage) command);
            return null;
        });
    }

    public void dispatch(TMessage m) {
        dispatcherWithResult.dispatch(m);
    }

}
