/*
 * Anagram.java 2018年6月9日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.leetcode.str.anagram;

/**
 * Anagram
 * @ClassName: Anagram 
 * @Description: TODO
 * @author jvbo
 * @date 2018年6月9日
 */
public class Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
        
    }
    
    public static boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a'] --;
        }
        for (int i : alphabet) {
            if(i != 0)
                return false;
        }
        return true;
    }
}
