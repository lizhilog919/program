package com.test.demo.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lizhi
 * 17-3-5
 */
public class DynamicProxyDemo {

    public static void main(String[] args){
        ProxyDemo.Task task = (ProxyDemo.Task) Proxy.newProxyInstance(ProxyDemo.Task.class.getClassLoader(), new Class[]{ProxyDemo.Task.class},new ProxyHandler(new ProxyDemo.RealTask()));
        task.doSomeThing();
    }

    public static class ProxyHandler implements InvocationHandler{

        public Object mProxied;

        ProxyHandler(Object proxied){
            mProxied = proxied;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("do something first");
            return method.invoke(mProxied,args);
        }
    }

}
