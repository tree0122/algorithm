package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * 最长回文子串(回文串是: 正读,反读 都一样的)
 *
 * 12104
 * #1#2#1#0#4#
 */
public class Q020201ManacherShortestEnd {

    public String shortest(String s){
        if (s == null || s.length() <= 1){
            return s;
        }
        char[] t = preprocess(s);
        int[] a = new int[t.length];
        int c = -1;
        int r = -1;
        int len = 0;
        for (int i = 0; i < t.length; i++) {
            a[i] = i >= r ? 1 : Math.min(r - i, a[2*c - i]);
            while (i - a[i] >= 0 && i + a[i] < t.length && t[i - a[i]] == t[i + a[i]]){
                a[i]++;
            }
            if (i + a[i] > r){
                r = i + a[i];
                c = i;
            }
            if (c == t.length){
                len = a[i];
                break;
            }
        }
        int left = (t.length - len) / 2;
        char[] ans = new char[left];
        for (int i = left - 1, j = 0; i >= 0; i--) {
            ans[j++] = s.charAt(i);
        }
        return String.valueOf(ans);
    }

    private char[] preprocess(String s) {
        char[] res = new char[s.length() * 2 + 1];
        for (int i = 0, j = 0; i < res.length; i++) {
            if (i % 2 == 0){
                res[i] = '#';
            }else {
                res[i] = s.charAt(j++);
            }
        }
        return res;
    }

}
