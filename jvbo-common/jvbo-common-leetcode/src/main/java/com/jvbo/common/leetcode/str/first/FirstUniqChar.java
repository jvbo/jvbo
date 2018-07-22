/*
 * FirstUniqChar.java 2018年6月9日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.leetcode.str.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 字符串中的第一个唯一字符
 * @ClassName: FirstUniqChar 
 * @Description: TODO
 * @author jvbo
 * @date 2018年6月9日
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        /*System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println('a' - 'b');*/
        
        String s = "leetcode";
        String s1 = "loveleetcode";
        /*System.out.println(firstUniqChar(s));
        System.out.println(firstUniqChar(s1));*/
        
        /*System.out.println(firstUniqChar1(s));
        System.out.println(firstUniqChar1(s1));*/
        
        /*System.out.println(firstNonRepeatingChar(s));
        System.out.println(firstNonRepeatingChar(s1));*/
        
        /*System.out.println(firstNonRepeatingChar1(s));
        System.out.println(firstNonRepeatingChar1(s1));*/
        
        System.out.println(firstNonRepeatingChar2(s));
        System.out.println(firstNonRepeatingChar2(s1));
    }
    
    private static int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) 
            freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if(freq[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
    
    private static int firstUniqChar1(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean uniq = true;
            for (int j = 0; j < chars.length; j++) {
                if(i ==j)
                    continue;
                if(chars[j] - chars[i] == 0){
                    uniq = false;
                    break;
                }else{
                    uniq = true;
                }
            }
            if(uniq){
                return i;
            }
        }
        return -1;
    }
    
    public static Character firstNonRepeatingChar(String s){
        Map<Character, Integer> counts = new LinkedHashMap<>(s.length());
        for (char c : s.toCharArray()) {
            counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
        }
        for (Entry<Character, Integer> entry : counts.entrySet()) {
            if(entry.getValue().intValue() == 1)
                return entry.getKey();
        }
        return null;
    }
    
    public static Character firstNonRepeatingChar1(String s){
        Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if(repeating.contains(letter)){
                continue;
            }
            if(nonRepeating.contains(letter)){
                nonRepeating.remove((Character)letter);
                repeating.add(letter);
            }else{
                nonRepeating.add(letter);
            }
        }
        return nonRepeating.get(0);
    }
    
    public static Character firstNonRepeatingChar2(String s){
        HashMap<Character, Integer> scoreboard = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(scoreboard.containsKey(c)){
                scoreboard.put(c, scoreboard.get(c) + 1);
            }else{
                scoreboard.put(c, 1);
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(scoreboard.get(c).intValue() == 1)
                return c;
        }
        return null;
    }
    
}
