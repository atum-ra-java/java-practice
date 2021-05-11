package com.atumra;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
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
      private List<Method> annotatedMethods = Arrays.stream(CalculatorLogging.class.getMethods())
        .filter(method -> method.isAnnotationPresent(Log.class))
        .collect(Collectors.toList());
      // CalculatorInvocationHandler(CalculatorLogging myClass) {
      //     this.myClass = myClass;
      // }

      CalculatorInvocationHandler(CalculatorLogging myClass) {
        this.myClass = myClass;
      }

      // В консоли дожно быть: executed method: calculation, param: 6
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // System.out.println(method + " annotation" + method.isAnnotationPresent(Log.class));
          if (annotatedMethods.contains(method) ) 
          System.out.println("executed method:" + method.getName() + ", param: " + Arrays.toString(args));
          return method.invoke(myClass, args);
      }
  }

}