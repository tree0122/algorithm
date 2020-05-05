package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class P0049GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String s : strs) {
            Map<Character, Integer> charMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            }
            List<String> list = map.get(charMap);
            if (list == null){
                list = new ArrayList<>();
                map.put(charMap, list);
            }
            list.add(s);
        }
        return new ArrayList<>(map.values());
    }

}
