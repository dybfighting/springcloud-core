package com.dyb.data.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author dyb
 * @version V1.0
 * @Package com.dyb.data.proxy
 * @Description: TODO
 * @date 2018/6/7 下午5:30
 */
@Component
public class UserServiceCGLIBProxy implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGlib proxy start --------");
//        System.out.println(o);
//        Object result = methodProxy.invokeSuper(target,objects);
        Object result = method.invoke(target,objects);
        System.out.println("CGlib proxy end --------");
        return result;
    }
}
