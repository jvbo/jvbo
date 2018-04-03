/*
 * Favorite.java 2018年2月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * 异构容器
 * @ClassName: Favorite 
 * @Description: TODO
 * @author jvbo
 * @date 2018年2月10日
 */
public class Favorite {
    private Map<Class<?>, Object> favorite = new HashMap<Class<?>, Object>();
    
    public <T> void putFavorite(Class<T> type, T instance) {
        if(type == null)
            throw new NullPointerException();
        favorite.put(type, instance);
    }
    
    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorite.get(type));
    }
    
    public static void main(String[] args) {
        Favorite f = new Favorite();
        f.putFavorite(String.class, "java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorite.class);
        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger,
                favoriteClass.getName());
        
    }
}
