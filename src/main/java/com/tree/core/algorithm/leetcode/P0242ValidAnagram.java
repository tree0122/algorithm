package com.tree.core.algorithm.leetcode;

import java.util.HashMap;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class P0242ValidAnagram {

    public boolean isAnagram(String s, String t){
        if (s == null && t == null){
            return true;
        }
        if (s == null || t == null){
            return false;
        }
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer count = map.get(c);
            if (count == null || count == 0){
                return false;
            }
            map.put(c, count - 1);
        }
        return true;
    }
}
