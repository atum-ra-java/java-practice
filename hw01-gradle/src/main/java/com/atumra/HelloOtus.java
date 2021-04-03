package com.atumra;

import com.google.common.base.Splitter;

/**
 *
 * To start the application:
 * gradlew.bat build
 * java -jar ./hw01-gradle/build/libs/gradleHelloWorld-0.1.jar
 *
 */

public class HelloOtus {

    public static void main(String[] args) {
      Iterable<String> result = Splitter.on(',')
        .trimResults().omitEmptyStrings().split("foo,bar,,   qux");
      System.out.println(result);
    }
}