package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestInvocationHandler implements InvocationHandler {

    private Object target;

    public TestInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy handler, before execute");
        Object result = method.invoke(target,args);
        System.out.println("Proxy handler, after execute");
        return result;
    }
}
