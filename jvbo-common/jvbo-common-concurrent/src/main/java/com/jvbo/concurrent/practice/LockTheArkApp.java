/*
 * LockTheArkApp.java 2018年4月2日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 基本类型的局部变量与引用变量的线程封闭性
 * @ClassName: LockTheArkApp 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月2日
 */
public class LockTheArkApp {
    
    public int lockTheArk(Collection<Animal> candidates){
        SortedSet<Animal> animals;
        int numPairs = 0;
        Animal candidate = null;
        
        // animals被封闭在方法中,不要使它们逸出
        animals = new TreeSet<Animal>();
        animals.addAll(candidates);
        for (Animal animal : animals) {
            if(candidate == null || !candidate.isPotentialMate(animal)){
                candidate = animal;
            }else{
                ++numPairs;
                candidate = null;
            }
        }
        return numPairs;
    }
    
    public static class Animal {

        public boolean isPotentialMate(Animal animal) {
            // TODO Auto-generated method stub
            return false;
        }
        
    }
    
    public static class SpeciesGenderComparatoe{
        
    }
    
}
