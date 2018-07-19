package com.competition;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        RealClass realClass = new RealClass();
        ProxyClass proxyClass = new ProxyClass(realClass);
        RealInterface realInterface = (RealInterface) Proxy.newProxyInstance(realClass.getClass().getClassLoader(),
                realClass.getClass().getInterfaces(), proxyClass);
        realInterface.request();
    }
}


interface RealInterface {
    public void request();
}

class RealClass implements RealInterface {
    @Override
    public void request() {
        System.out.println("test");
    }
}

class ProxyClass implements InvocationHandler {

    private RealInterface realClass;

    public ProxyClass(RealInterface realClass) {
        this.realClass = realClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("1");
        Object result = method.invoke(realClass, args);
        System.out.println("2");
        return result;
    }
}