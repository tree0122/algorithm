package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 *
 *
 * Example 1:
 *
 * Input:
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 *
 * Input:
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * Output: []
 */
public class P0030SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || words == null || s.length() == 0 || words.length == 0
               || words[0].length() * words.length > s.length()){
            return ans;
        }
        int wCount = words.length, len = words[0].length(), wLen = len * wCount;
        HashMap<String, Integer> wordMap = new HashMap<>(wCount);
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= s.length() - wLen; i++) {
            HashMap<String, Integer> map = new HashMap<>(wCount);
            int j = 0;
            for (j = 0; j < wCount; j++) {
                int start = i + j * len;
                String tmp = s.substring(start, start + len);
                if (!wordMap.containsKey(tmp)){
                    break;
                }
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                if (map.get(tmp) > wordMap.get(tmp)){
                    break;
                }
            }
            if (j == wCount){
                ans.add(i);
            }
        }
        return ans;
    }

}
