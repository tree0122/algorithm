package com.tree.core.algorithm.leetcode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 */
public class P0140WordBreak2 {

    //Use DP to store valid break points (dp[i] = s[0:i-1] can be made up by words in dict)
    //Use break points to build path from the end.
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return new ArrayList<>();
        }
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> ans = new LinkedList<>();
        boolean[] d = new boolean[s.length() + 1]; //d[i] = s[i:sLen-1]能被有效切分
        d[d.length - 1] = true;
        int maxLen = 0;
        for (String w : wordSet) {
            maxLen = Math.max(maxLen, w.length());
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            int wordEnd = Math.min(s.length(), i + maxLen);
            for (int j = wordEnd; j > i; j--) {
                String word = s.substring(i, j);
                if (d[j] && wordSet.contains(word)) {
                    d[i] = true;
                }
            }
        }
        p(s, 0, wordSet, new LinkedList<>(), ans, d);
        return ans;
    }

    private void p(String s, int i, Set<String> w, List<String> c, List<String> a, boolean[] d) {
        if (i == s.length()) {
            a.add(c.stream().collect(Collectors.joining(" ")));
            return;
        }
        for (int k = i; k < s.length(); k++) {
            String word = s.substring(i, k + 1);
            if (d[k + 1] && w.contains(word)) {
                c.add(word);
                p(s, k + 1, w, c, a, d);
                c.remove(c.size() - 1);
            }
        }
    }

    @Test
    public void t() {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> list = wordBreak(s, wordDict);
        System.out.println(list);
    }

/*

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0){
            return new ArrayList<>();
        }
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> ans = new LinkedList<>();
        p(s, 0, wordSet, new LinkedList<>(), ans);
        return ans;
    }

    private void p(String s, int i, Set<String> w, List<String> c, List<String> a) {
        if (i == s.length()){
            a.add(c.stream().collect(Collectors.joining(" ")));
            return;
        }
        for (int k = i; k < s.length(); k++) {
            if (w.contains(s.substring(i, k + 1))){
                c.add(s.substring(i, k + 1));
                p(s, k + 1, w, c, a);
                c.remove(c.size() - 1);
            }
        }
*/



    }

