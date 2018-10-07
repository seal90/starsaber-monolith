package org.seal.startsaber.sealstarsaberdemo.mytest;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {


//        InvocationHandler invocationHandler = new InvocationHandler(){
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        };
//        ClassLoader classLoader = ProxyTest.class.getClassLoader();
//        StdSerializer stdSerializer = (StdSerializer)Proxy.newProxyInstance(classLoader, new Class[]{StdSerializer.class}, invocationHandler);
//        System.out.println(stdSerializer);
//
//        StdSerializer stdSerializer = (StdSerializer)Class.forName(StdSerializer.class.getName()).newInstance();
//        System.out.println(stdSerializer);

        StdSerializer stdSerializer1 = BeanUtils.instantiateClass(StdSerializer.class);


    }
}
