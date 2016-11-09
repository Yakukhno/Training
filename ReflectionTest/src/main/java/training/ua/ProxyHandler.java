package training.ua;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

    private Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy invocation");

        if (method.getName().startsWith("get")) {
            return method.invoke(object, args);
        } else {
            throw new IllegalAccessException("Settters are not a available");
        }
    }
}
