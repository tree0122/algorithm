package com.tree.core.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 */
public class P0290WordPattern {

    public boolean wordPattern(String pattern, String str){
        String[] a = str.split(" ");
        if (pattern.length() != a.length){
            return false;
        }
        HashMap<Character, String> map = new HashMap<>(pattern.length());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String ch = map.get(c);
            if (ch == null){
                if (set.contains(a[i])){
                    return false;
                }
                map.put(c, a[i]);
                set.add(a[i]);
            }else if (!ch.equals(a[i])){
                return false;
            }
        }
        return true;
    }

}
