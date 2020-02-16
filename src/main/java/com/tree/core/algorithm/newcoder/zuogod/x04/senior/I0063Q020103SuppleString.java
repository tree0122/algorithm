package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * KMP的next应用
 * 京东题
 *
 * 给定一个字符串s, 在s后面追加一个字符串m, 合并后的字符串包含两个s
 * 求字符串m, 要求字符串m的长度最小
 */
public class I0063Q020103SuppleString {

    public String supple(String s){
        if (s == null || s.length() <= 1){
            return s;
        }
        int[] a = new int[s.length() + 1];
        int cn = 0;
        a[cn] = -1;
        for (int i = 2; i <= s.length();) {
            if (s.charAt(i - 1) == s.charAt(cn)){
                a[i++] = ++cn;
            }else if (cn > 0){
                cn = a[cn];
            }else {
                i++;
            }
        }
        return s.substring(a[s.length()]);
    }

}
