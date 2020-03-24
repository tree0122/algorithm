package com.tree.core.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 *
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 * Example 1:
 *
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * Example 2:
 *
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 */
public class P0170TwoSum3 {

    HashMap<Integer, Integer> map = new HashMap<>();

    public void add(int num){
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    public boolean find(int target){
        Map.Entry<Integer, Integer> first = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (first == null){
                first = entry;
            }
            int next = target - entry.getKey();
            if ((next != first.getKey() && map.containsKey(next))
                    || (next == first.getKey() && first.getValue() > 1)){
                return true;
            }
        }
        return false;
    }

}
