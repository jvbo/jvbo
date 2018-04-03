/*
 * App.java 2018年2月11日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName(args[0]);
        for (Method m : testClass.getDeclaredMethods()) {
            if(m.isAnnotationPresent(Test.class)){
                tests ++;
                try {
                    m.invoke(null);
                } catch (InvocationTargetException e) {
                    Throwable exc = e.getCause();
                    Class<? extends Exception>[] excTypes = 
                            m.getAnnotation(ExceptionTest.class).value();
                    int oldPassed = passed;
                    for (Class<? extends Exception> excType : excTypes) {
                        if(excType.isInstance(exc)){
                            passed++;
                            break;
                        }
                    }
                    if(passed == oldPassed){
                        System.out.printf("Test %s failed: %s %n", m, exc);
                    }
                    /*if(excType.isInstance(exc)){
                        passed ++;
                    }else{
                        System.out.printf("Test %s failed:expected %s, got %s%n", m, excType.getName(), exc);
                    }*/
                    
                    //System.out.println(m + "failed:" + exc);
                } catch (Exception e) {
                    System.out.println("invalid @Test:" + m);
                }
                passed ++;
            }
        }
        System.out.printf("Passed: %d, Failed:%d%n", passed, tests, passed);
        
    }
}
