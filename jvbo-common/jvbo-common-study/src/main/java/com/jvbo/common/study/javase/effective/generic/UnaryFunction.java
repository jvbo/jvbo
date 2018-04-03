/*
 * UnaryFunction.java 2018年2月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.generic;

public interface UnaryFunction<T> {
    T apply(T arg);
    
    static UnaryFunction<Object> IDENTITY_FUNCTION = 
            new UnaryFunction<Object>(){
      public Object apply(Object arg){
          return arg;
      }  
    };
    
    public static <T> UnaryFunction<T> identityFunction(){
        return (UnaryFunction<T>)IDENTITY_FUNCTION;
    }
    
    public static void main(String[] args) {
        String[] strings = {"1", "2", "3", "4"};
        UnaryFunction<String> sameString = identityFunction();
        for(String s : strings)
            System.out.println(sameString.apply(s));
        
        Number[] numbers = {1, 2.0, 3L};
        for(Number n : numbers)
            System.out.println(n);
    }
    
    
}
