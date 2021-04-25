package com.atumra;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.atumra.annotation.Test;
import com.google.common.base.Optional;
import com.atumra.annotation.Before;
import com.atumra.annotation.After;

public class Framework {

    static private int passedTests;
    static private int failedTests;

    /**
     * Gets class for test. looks for methods and annotation,
     * and invokes them in a sequence order
     * 
     * @param test - test.class
     */

    public static void launchTest(Class<?> test) {

        Method[] testMethods = test.getDeclaredMethods();
        

        //set of test
        List<List<Method>> fullList = new ArrayList<>();
        

        for (Method method : testMethods) {
            if (method.isAnnotationPresent((Class<? extends Annotation>) Test.class)) {
                //full list of methods for each test
                List<Method> testList = new LinkedList<>();    

                testList.add(method);
                fullList.add(testList);
            }
        }

        // add to fullList for each element (test suit)  Before and After tests
        for (Method method : testMethods) {
            if (method.isAnnotationPresent((Class<? extends Annotation>) Before.class)) {
                fullList.forEach(testList -> testList.add(0, method));
            }
            if (method.isAnnotationPresent((Class<? extends Annotation>) After.class)) {
                fullList.forEach(testList -> testList.add(method));
            }
        }

        // invoke methods on test class
        for (List<Method> testListWithBeforeAfter : fullList) {
            try {
                final Object testObj = test.getConstructor().newInstance();
                for(int i = 0; i < testListWithBeforeAfter.size(); i++)  {
                   
                // for (Method method : testListWithBeforeAfter) {
                    var method = testListWithBeforeAfter.get(i);
                    try {
                        method.invoke(testObj);
                    } catch (InvocationTargetException e) {
     
                        // так не работает c моим компилятором graalvm-ce-java11-20.0.0 
                        // а по докам должно вроде
                        // String ext = Optional.of(e.getCause().getMessage()).or("0");
                       String ext=  e.getCause().getMessage();
                       if (ext == null) ext = "0";

                       switch (ext) {
                            case "correct": 
                                System.out.println("Test '" + method.getName() + "': PASS");
                                passedTests++;
                                break;
                            case "not correct":
                                System.out.println("Test '" + method.getName() + "': DOESN'T PASS");
                                failedTests++;
                                break;
                            case "before":
                                System.out.println("Method with annotation before RIP");
                                method = testListWithBeforeAfter.get(i = testListWithBeforeAfter.size() - 1);
                                method.invoke(testObj);
                                break;
                            default:
                                System.out.println("Test '" + method.getName() + "': execution error");
                                failedTests++;
                                break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        printStat();
    }

    /**
     * exact method of framework for comparing ints
     * 
     * @param a - expected
     * @param b - result
     * @throws Exception
     */
    public static void compareInt(int a, int b) throws Exception {
        if (a == b)
            throw new Exception("correct");
        else
            throw new Exception("not correct");
    }

    /**
     * Stats
     */
    private static void printStat() {
        System.out.println();
        System.out.println("Total performed " + (passedTests + failedTests));
        System.out.println("Tests passed: " + passedTests);
        System.out.println("Tests failed: " + failedTests);
        passedTests = 0;
        failedTests = 0;
    }

}