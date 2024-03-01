package ru.zakharova;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class Utils {



        public static Object cash(Object object) throws IllegalAccessException {

            ClassLoader classLoader = object.getClass().getClassLoader();

            //Получаем все интерфейсы, которые реализует оригинальный объект
            Class[] interfaces = object.getClass().getInterfaces();
            Object proxyF = Proxy.newProxyInstance(classLoader, interfaces, new FractionableInvocationHandler((Fractionable) object));
                return proxyF;

        }

}
