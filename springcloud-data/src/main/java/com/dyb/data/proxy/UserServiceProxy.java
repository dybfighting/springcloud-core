package com.dyb.data.proxy;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author dyb
 * @version V1.0
 * @Package com.dyb.data.proxy
 * @Description: jdk动态代理
 * @date 2018/6/7 下午4:31
 */
@Component
public class UserServiceProxy implements InvocationHandler{
    private Object target;

    public Object bind(Object o){
        this.target = o;
        return Proxy.newProxyInstance(o.getClass().getClassLoader(),o.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy start ---");
        System.out.println("method name:"+method.getName());
        System.out.println(Arrays.toString(args));
        Object result = method.invoke(target,args);
        System.out.println("Proxy end ---");
        return result;
    }
}
