package com.tree.core.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.
 * <p>
 * Example:
 * <p>
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class P0093RestoreIpAddress {
    public List<String> restoreIpAddresses(String s) {
        LinkedList<String> ans = new LinkedList<>();
        int[] p = new int[4];
        p(s, 0, p, 0, ans);
        return ans;
    }

    private void p(String s, int i, int[] p, int pi, LinkedList<String> a) {
        if (pi == 4 && i == s.length()) {
            a.add(p[0] + "." + p[1] + "." + p[2] + "." + p[3]);
            return;
        }else if (pi == 4 || i == s.length()){
            return;
        }
        for (int j = 1; j <= 3 && i + j <= s.length(); j++) {
            int v = Integer.parseInt(s.substring(i, i + j));
            if (v > 255 || j >= 2 && s.charAt(i) == '0'){
                break;
            }
            p[pi] = v;
            p(s, i + j, p, pi + 1, a);
        }
    }

    /*private void p(String s, int i, String c, List<String> a) {
        if (i == s.length()) {
            if (c.split(".").length == 4) {
                a.add(c);
            }
            System.out.println(c);
            return;
        }
        for (int k = i; k < s.length(); k++) {
            p(s, k + 1, c, a);
            p(s, k + 1, c + "." + s.substring(i, k), a);
        }
    }*/

/*
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new LinkedList<>();
        int[] path = new int[4];
        helper(ret, s, 0, path, 0);
        return ret;
    }

    void helper(List<String> acc, String s, int idx, int[] path, int segment) {
        if (segment == 4 && idx == s.length()) {
            acc.add(path[0] + "." + path[1] + "." + path[2] + "." + path[3]);
            return;
        } else if (segment == 4 || idx == s.length()) {
            return;
        }

        for (int len = 1; len <= 3 && idx + len <= s.length(); len++) {
            int val = Integer.parseInt(s.substring(idx, idx + len));
            // range check, no leading 0.
            if (val > 255 || len >= 2 && s.charAt(idx) == '0')
                break;

            path[segment] = val;
            helper(acc, s, idx + len, path, segment + 1);
            path[segment] = -1; // for debug.
        }
    }*/

    @Test
    public void t() {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }

}
