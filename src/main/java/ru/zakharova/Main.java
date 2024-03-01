package ru.zakharova;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
            Fraction f = new Fraction(1,2);
      Fractionable proxyF =(Fractionable)  Utils.cash(f);
        System.out.println(proxyF.doubleValue());
        System.out.println(proxyF.doubleValue());
        System.out.println(proxyF.doubleValue());
        proxyF.setNum(5);
        System.out.println(proxyF.doubleValue());
        System.out.println(proxyF.doubleValue());
        proxyF.setDenum(6);
        System.out.println(proxyF.doubleValue());
        System.out.println(proxyF.doubleValue());
    }
}