package com.tree.core.algorithm.leetcode;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 */
public class P0205IsomorphicString {

    public boolean isIsomorphic(String s, String t){
        if ((s == null && t == null)
                || (s.length() == 0 && t.length() == 0)
                || (s.length() == 1 && t.length() == 1)
        ){
            return true;
        }
        if ((s == null || t == null) || s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            Integer sCount = sMap.put(sc, sMap.getOrDefault(sc, 1) + i);
            Integer tCount = tMap.put(tc, tMap.getOrDefault(tc, 1) + i);
            if (sCount != tCount){
                return false;
            }
        }
        return true;
    }

    public boolean awesome(String s, String t){
        int[] si = new int[256];
        int[] ti = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (si[s.charAt(i)] != ti[t.charAt(i)]){
                return false;
            }
            si[s.charAt(i)] = i + 1;
            ti[t.charAt(i)] = i + 1;
        }
        return true;
    }


}
