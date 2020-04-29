package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * KMP算法详情与应用
 *
 * 解决字符串的包含问题
 */
public class I0061Q020101KMP {

    public int search(String s1, String s2){
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0 || s1.length() < s2.length()){
            return -1;
        }
        int i = 0;
        int j = 0;
        int[] a = next(s2);
        while (i < s1.length() && j < s2.length()){
            if (s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else if (j > 0){
                j = a[j];
            }else {
                i++;
            }
        }
        return s2.length() == j ? i - j : -1;
    }

    private int[] next(String s) {
        int cn = 0;
        int[] a = new int[s.length()];
        a[0] = -1;
        for (int i = 2; i < s.length();) {
            if (s.charAt(i - 1) == s.charAt(cn)){
                a[i++] = ++cn;
            }else if (cn > 0){
                cn = a[cn];
            }else {
                i++;
            }
        }
        return a;
    }

    public int right(String s1, String s2){
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()){
            if (s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else {// 不匹配时, j回退j个距离到0, i回退j个距离, 然后比较下个字符
                i = i - j + 1;
                j = 0;
            }
        }
        return j == s2.length() ? i - j : -1;
       /*
        for (int i = 0; i < s1.length(); i++) {
            int j = 0;
            int k = i;
            for (; j < s2.length();) {
                if (s1.charAt(k) == s2.charAt(j)){
                    j++;
                    k++;
                }else {
                    break;
                }
            }
            if (j == s2.length()){
                return i;
            }
        }
        return -1;*/
    }

}
