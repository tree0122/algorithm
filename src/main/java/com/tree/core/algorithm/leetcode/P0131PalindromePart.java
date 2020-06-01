package com.tree.core.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class P0131PalindromePart {

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<List<String>> ans = new LinkedList<>();
        p(s, 0, new LinkedList<>(), ans);
        return ans;
    }

    private void p(String s, int i, List<String> c, List<List<String>> a) {
        if (i == s.length()) {
            a.add(new ArrayList<>(c));
            return;
        }
        for (int k = i; k < s.length(); k++) {
            if (isP(s, i, k)) {
                c.add(s.substring(i, k + 1));
                p(s, k + 1, c, a);
                c.remove(c.size() - 1);
            }
        }
    }

    private boolean isP(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void t() {
        String s = "aab";
        List<List<String>> lists = partition(s);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

}
