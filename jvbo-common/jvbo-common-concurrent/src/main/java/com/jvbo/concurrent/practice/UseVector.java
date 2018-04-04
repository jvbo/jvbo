/*
 * UseVector.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.Vector;

/**
 * Vector上可能导致混乱结果的复合操作,但是Vector的规范使其会抛出异常提示开发者
 * @ClassName: UseVector 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
/*public class UseVector {
    
    @SuppressWarnings("rawtypes")
    public static Object getLast(Vector list){
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }
    
    @SuppressWarnings("rawtypes")
    public static void deleteLast(Vector list){
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }
    
}*/

/**
 * 在使用客户端加锁的Vector上的复合操作
 * @ClassName: UseVector 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
public class UseVector {
    /**
     * 由于同步容器要遵守同步策略,即支持客户端加锁,因此可能会创建一些新的操作,
     * 只要我们知道应该使用哪一个锁,那么这些新操作就与容器的其他操作一样都是原子操作;
     * 同步容器类通过其自身的锁来保护它的每个方法;通过获得容器类的锁,
     * 我们可以使getLast和deleteLast成为原子操作,并确保Vector的大小在调用size和get之间不会发生变化;
     */
    
    @SuppressWarnings("rawtypes")
    public static Object getLast(Vector list){
        synchronized(list){
            int lastIndex = list.size() - 1;
            return list.get(lastIndex);
        }
    }
    
    @SuppressWarnings("rawtypes")
    public static void deleteLast(Vector list){
        synchronized(list){
            int lastIndex = list.size() - 1;
            list.remove(lastIndex);
        }
    }
    
}
