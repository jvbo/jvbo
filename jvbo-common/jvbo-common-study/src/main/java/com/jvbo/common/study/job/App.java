/*
 * App.java 2018年3月21日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.job;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;

/**
 * Java中的四个重要部分-漫谈
 * @ClassName: App 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月21日
 */
public class App {
    /**
     * 1. Java的数据结构相关的类实现原理，比如LinkedList，ArrayList，HashMap，TreeMap这一类的;
     *  a. 先问你HashMap是不是有序的？
     *     你肯定回答说，不是有序的。那面试官就会继续问你，有没有有顺序的Map实现类？
     *     你如果这个时候说不知道的话，那这个问题就到此结束了。如果你说有TreeMap和LinkedHashMap。
     *     那么面试官接下来就可能会问你，TreeMap和LinkedHashMap是如何保证它的顺序的？
     *     如果你回答不上来，那么到此为止。如果你依然回答上来了，那么面试官还会继续问你，你觉得它们两个哪个的有序实现比较好？
     *     如果你依然可以回答的话，那么面试官会继续问你，你觉得还有没有比它更好或者更高效的实现方式？
     *     如果你还能说出来的话，那么就你所说的实现方式肯定依然可以问你很多问题。
     * 
     * 2. Java并发包当中的类，它们都有哪些作用，以及它们的实现原理，这些类就是java.concurrent包下面的;
     *  a. 可能会先问你，如果想实现所有的线程一起等待某个事件的发生，当某个事件发生时，所有线程一起开始往下执行的话，有什么好的办法吗？
     *     这个时候你可能会说可以用栅栏（Java的并发包中的CyclicBarrier），那么面试官就会继续问你，你知道它的实现原理吗？
     *     如果你继续回答的话，面试官可能会继续问你，你还知道其它的实现方式吗？
     *     如果你还能说出很多种实现方式的话，那么继续问你，你觉得这些方式里哪个方式更好？
     *     如果你说出来某一个方式比较好的话，面试官依然可以继续问你，那如果让你来写的话，你觉得还有比它更好的实现方式吗？
     *     如果你这个时候依然可以说出来你自己更好的实现方式，那么面试官肯定还会揪着这个继续问你。
     * 
     * 3. IO包和NIO包中的内容。这部分里面NIO会是重点，IO包大部分都会比较熟悉，因此可能会直接略过，直接NIO的内容;
     *  a. IO包和NIO包的内容相对来说不是很多，首先NIO模型要熟悉，特别是其中的selector一定要非常清楚它的职责和实现原理。其实NIO的核心是IO线程池，一定要记住这个关键点。
     *     有的时候，可能也会问你IO包的设计模式（装饰器模式），为什么要这样设计？
     *     有的面试官还会问你有没有更好的设计，这个时候如果你不知道请果断说自己现在的水平有限，想不出来更好的设计，千万不要信口开河
     * 
     * 4. Java的虚拟机的内容。这部分主要包括三部分，GC、类加载机制，以及内存;
     *  a. GC部分
     *      可以先问你什么时候一个对象会被GC？
     *      接着继续问你为什么要在这种时候对象才会被GC？
     *      接着继续问你GC策略都有哪些分类？
     *      你如果说出来了，继续问你这些策略分别都有什么优劣势？都适用于什么场景？
     *      你继续说出来了以后，给你举个实际的场景，让你选择一个GC策略？
     *      你如果选出来了，继续问你，为什么要选择这个策略？
     *  b. 类加载机制
     *      Java的类加载器都有哪些？
     *      回答了这些以后，可能会问你每个类加载器都加载哪些类？
     *      说完以后，可能会问你这些类加载之间的父子关系是怎样的？
     *      你在回答的时候可能会提到双亲委派模型，那么可以继续问你什么是双亲委派模型？
     *      你解释完了以后，可能会继续问你，为什么Java的类加载器要使用双亲委派模型？
     *      你回答完以后，可能会继续问你如何自定义自己的类加载器，自己的类加载器和Java自带的类加载器关系如何处理？
     *  c. 关于内存
     *      内存分为哪几部分，这些部分分别都存储哪些数据？
     *      然后继续问你一个对象从创建到销毁都是怎么在这些部分里存活和转移的？
     *      接着可能会问你，内存的哪些部分会参与GC的回收？
     *      完事以后，可能还会问你Java的内存模型是怎么设计的？
     *      你回答了以后，还会继续问你为什么要这么设计？
     *      问完以后，还可能会让你结合内存模型的设计谈谈volatile关键字的作用？
     *      你在谈的时候，肯定会提到可见性，那么接着可见性这三个字，还可以继续问你并发的内容。
     * @throws ParseException 
     */
    
    public static void main(String[] args) throws ParseException {
        /*System.out.println(Instant.now().toEpochMilli());
        String str = "2018-04-26 23:00:00";
        System.out.println(DateUtils.parseDate(str, "yyyy-MM-dd"));
        Date date = null;
        System.out.println(date);*/
        
        /*Map<Integer, String> result = Maps.newHashMap();
        result.put(1, "1");
        result.put(2, "1");
        result.put(5, "1");
        result.put(4, "1");
        result.put(3, "1");
        System.out.println(result);
        Map<Integer, String> finalMap = new LinkedHashMap<>();
        result.entrySet().stream()
                .sorted(Map.Entry.<Integer, String>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        System.out.println(finalMap);*/
        
        /*System.out.println(String.class.getSimpleName());
        
        String phone = "134****9511";
        System.out.println(phone.substring(phone.length() - 4, phone.length()));
        System.out.println(phone.substring(1, phone.length()));*/
        BigDecimal b = new BigDecimal("0.01527");
        System.out.println(b.toString());
        Double d = Double.valueOf(b.toString());
        String i = "1.1.111";
        String[] strArr = StringUtils.split(i, ".");
        System.out.println(Arrays.toString(strArr));
    }

}
