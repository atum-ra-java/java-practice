package com.atumra;

import com.google.common.base.Splitter;

/**
 *
 * To start the application:
 * ./gradlew
 * java -jar ./hw01-gradle/build/libs/gradleHelloWorld-0.1.jar
 *
 */

public class HelloOtus {

    public static void main(final String[] args) {
      final Iterable<String> result = Splitter.on(',')
        .trimResults().omitEmptyStrings().split("foo,bar,,   qux");
      System.out.println(result);
    }
}