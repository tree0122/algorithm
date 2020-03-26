package com.tree.core.algorithm.leetcode;

import java.util.HashMap;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 *
 * Example 1:
 *
 * Input:  "69"
 * Output: true
 * Example 2:
 *
 * Input:  "88"
 * Output: true
 * Example 3:
 *
 * Input:  "962"
 * Output: false
 */
public class P0246StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num){
        HashMap<Character, Character> map = new HashMap<>(4);
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        for (int i = 0, len = num.length() - 1; i <= len / 2; i++) {
            if (map.get(num.charAt(i)) != num.charAt(len - i)){
                return false;
            }
        }
        return true;
    }

}
