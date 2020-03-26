package com.tree.core.algorithm.leetcode;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class P0243ShortestWordDistance {

    public int shortestDistance(String[] words, String word1, String word2){
        int ans = Integer.MAX_VALUE;
        for (int i = 0, p = -1, q = -1; i < word1.length(); i++) {
            if (words[i] == word1){
                p = i;
            }else if (words[i] == word2){
                q = i;
            }
            if (p != -1 && q != -1){
                ans = Math.min(ans, Math.abs(p - q));
            }
        }
        return ans;
    }

}
