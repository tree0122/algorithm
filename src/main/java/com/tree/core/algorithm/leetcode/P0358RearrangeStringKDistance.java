package com.tree.core.algorithm.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.
 *
 * All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
 *
 * Example 1:
 *
 * str = "aabbcc", k = 3
 *
 * Result: "abcabc"
 *
 * The same letters are at least distance 3 from each other.
 * Example 2:
 *
 * str = "aaabc", k = 3
 *
 * Answer: ""
 *
 * It is not possible to rearrange the string.
 */
public class P0358RearrangeStringKDistance {

    public String rearrangeString(String s, int k){
        if (s == null || s.length() == 0 || k < 0){
            return "";
        }
        if (k == 0){
            return s;
        }
        int bucket = s.length() / k;
        int remain = s.length() % k;
        int delta = 0;
        char[] cs = new char[s.length()];
        HashMap<Integer, Integer> map = new HashMap<>(s.length());
        PriorityQueue<Integer> heap = new PriorityQueue<>((i1, i2) -> map.get(i2) - map.get(i1));
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            Integer count = map.get(c);
            count = count == null ? 1 : count + 1;
            map.put(c, count);
            if (count > bucket + 1){
                return "";
            }
            if (count == bucket + 1){
                delta++;
            }
            if (delta > remain){
                return "";
            }
        }
        for (Integer c : map.keySet()) {
            heap.offer(c);
        }
        for (int i = 0, p = heap.poll(); i < cs.length; i++) {
            cs[i] = (char) p;
            Integer count = map.get(p);
            if (count == 0){
                p = heap.poll();
            }else {
                map.put(p, count - 1);
            }
            i += k;
            if (i >= cs.length){
                i %= k;
                i++;
            }
        }
        return String.valueOf(cs);
    }

}
