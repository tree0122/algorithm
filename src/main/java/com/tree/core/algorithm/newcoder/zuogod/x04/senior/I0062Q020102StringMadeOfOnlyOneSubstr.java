package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * KMP应用
 *
 * next数组应用
 *
 * 给定一个字符串s, 判断s是否仅能由一个子串组成
 */
public class I0062Q020102StringMadeOfOnlyOneSubstr {

    public boolean madeOfOneSubstr(String s) {
        if (s == null || s.length() <= 1){
            return true;
        }
        int cn = 0;
        int[] a = new int[s.length()];
        for (int i = 1; i < s.length();) {
            if (s.charAt(i) == s.charAt(cn)){
                a[i++] = ++cn;
            }else if (cn > 0){
                cn = a[cn];
            }else {
                i++;
            }
        }
        int len = s.length() - a[s.length() - 1];
        return s.length() % len == 0 && s.length() / len > 1;
    }


}
