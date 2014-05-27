package experiment;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.function.Function;

public class DispatcherWithResult<TMessage, TResult> {

    private Dictionary<Object, Function<TMessage, TResult>> dictionary = new Hashtable<>();

    public void register(Class clazz, Function<TMessage, TResult> function) {
        dictionary.put(clazz, function);
    }

    public TResult dispatch(TMessage m) {
        Function<TMessage, TResult> handler = dictionary.get(m.getClass());
        return handler.apply(m);
    }
}
