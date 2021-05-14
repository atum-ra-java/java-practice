package com.atumra;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


public class Ioc {

  private Ioc() {
  }

  static CalculatorLogging createCalculator() {
      InvocationHandler handler = new CalculatorInvocationHandler(new Calculator());

      return (CalculatorLogging) Proxy.newProxyInstance(
        Ioc.class.getClassLoader(),
        // interface, which class implements
        new Class<?>[]{CalculatorLogging.class},
        handler);
  }

  static class CalculatorInvocationHandler implements InvocationHandler {
      private final CalculatorLogging myClass;
      private Set<Object> annotatedParamCounts;

      CalculatorInvocationHandler(CalculatorLogging myClass) throws IllegalArgumentException {
        this.myClass = myClass;
        Class<?> cl= myClass.getClass();

        annotatedParamCounts = Arrays.stream(cl.getMethods())
        .filter(method -> method.isAnnotationPresent(Log.class))
        .map(method -> String.valueOf(method.getParameterCount())+method.getName())
        .collect(Collectors.toSet());
      }

      // В консоли дожно быть: executed method: calculation, param: 6
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // System.out.println(method + " annotation" + method.isAnnotationPresent(Log.class));
        
          if (annotatedParamCounts.contains(String.valueOf(method.getParameterCount())+method.getName()) ) 
          System.out.println("executed method:" + method.getName() + ", param: " + Arrays.toString(args));
          return method.invoke(myClass, args);
      }
  }

}