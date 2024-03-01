package ru.zakharova;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class FractionableInvocationHandler implements InvocationHandler {
    private Fractionable fractionable;
    boolean state = false; // true - есть кеш, false = нет
    HashMap<String, Object> save = new HashMap<>();

    public FractionableInvocationHandler(Fractionable fractionable) {
        this.fractionable = fractionable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.isAnnotationPresent(Cash.class)) {
            if (!(state)){
                Object object = method.invoke(fractionable, args);
                save.put (method.getName(),object) ;
                state = true;
                return  object;
                }
            else {
                Object object = save.get(method.getName()) ;
                //System.out.println(object);
                return object;}
            }

        if (method.isAnnotationPresent(Mutator.class)) {
            state = false;
            save.clear();
            }


        return method.invoke(fractionable, args);
    }
}
