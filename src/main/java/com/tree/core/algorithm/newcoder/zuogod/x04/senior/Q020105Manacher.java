package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * 最长回文子串(回文串是: 正读,反读 都一样的)
 *
 * 12104
 * #1#2#1#0#4#
 */
public class Q020105Manacher {

    public String maxLen(String s){
        if (s == null || s.length() <= 1){
            return s;
        }
        char[] t = preprocess(s);
        int[] a = new int[t.length];
        int c = -1;
        int r = -1;
        int max = 0;
        int idx = 0;
        for (int i = 0; i < t.length; i++) {
            a[i] = i >= r ? 1 : Math.min(r - i, a[2*c - i]);
            while (i - a[i] >= 0 && i + a[i] < t.length && t[i - a[i]] == t[i + a[i]]){
                a[i]++;
            }
            if (i + a[i] > r){
                c = i;
                r = i + a[i];
            }
            if (max < a[i]){
                max = a[i];
                idx = i;
            }
        }
        int left = (idx - max + 1) / 2;
        return s.substring(left, left + max - 1);
    }

    public String right(String s){
        if (s == null || s.length() <= 1){
            return s;
        }
        char[] t = preprocess(s);
        int maxLen = 0;
        int idx = 0;
        for (int i = 0; i < t.length; i++) {
            int len = 1;
            while (i - len >= 0 && i + len < t.length && t[i - len] == t[i + len]){
                len++;
            }
            if (len > maxLen){
                maxLen = len;
                idx = i;
            }
        }
//        int begin = (idx - 1) / 2 - (maxLen - 1) / 2;
        int left = (idx - maxLen + 1) / 2;
        return s.substring(left, left + maxLen - 1);
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

    /**
     * 最长回文子串的解法具体思路:
     *
     * 基本概念
     *  回文半径: 当前位置i的最大回文半径
     *  整体回文右边界R: 截止当前位置时, 最右的文本右边界
     *  回文右边界中心C: 整体回文右边界的中心(首次到达回文右边界时,s所在的下标位置)
     *  i' = 2*C - i: 表示以C为中心的i的左对称点
     *  a[i]: 表示i的回文半径
     *
     * 具体分析:
     * 1. 情况1, i >= R, 即i不在C的回文范围内(包括在回文右边界上), i位置以半径a[i]=1开始暴力扩
     * 2. 以下情况, i < R, 即i在C的回文范围内(再分3种情况),
     *  1) 情况2, a[i'] < R - i, 即i'的回文左边界也在C的回文范围内, 故a[i] = a[i']
     *  2) 情况3, a[i'] > R - i, 即i'的回文左边界在C的回文范围外, 故a[i] = R - i
     *  3) 情况4, a[i'] == R - i, 即i'的回文左边界刚好是C的回文左边界, i位置以半径a[i]=R-i开始暴力扩
     *
     * @param s 字符串
     * @return 最长回文子串的长度
     */
    public int idea(String s){
        if (s == null || s.length() == 0){
            return 0;
        }

        //预处理字符串
        char[] p = preprocess(s);
        int len = 0;
        int r = -1; //整体回文右边界
        int c = -1; //回文右边界的中心
        int[] a = new int[p.length]; //a[i]表示i位置的最大回文半径
        for (int i = 0; i < p.length; i++) {
            int l = 0;
            if (i >= r){ //当前位置i不在右边界内
                //i开始暴力扩
                l = 1;
                while (i - l != -1
                        && i + l != p.length
                        && p[i - l] == p[i + l]
                ){ //找出i位置的最大回文半径
                    l++;
                }
                a[i] = l;
            }else { //潜台词: 当前位置i在右边界内(i < r)
                if (a[2*c - i] == r - i){ //2*c - i表示i以c为中心的对称点i', i'的左边界刚好是c的左边界
                    //r-i已经是i半径a[i]一部分, r开始暴力扩
                    l = r - i;
                    while (i - l != -1
                            && i + l != p.length
                            && p[i - l] == p[i + l]
                    ){ //找出i位置的最大回文半径
                        l++;
                    }
                    a[i] = l;
                }else if (a[2*c - i] < r - i){ //i'的左边界在c的回文范围内
                    a[i] = a[2*c - i];
                }else { //i'的左边界在c回文范围外
                    a[i] = r - i;
                }
            }
            //重新赋值r和c, 当前位置i与其回文半径a[i]的和, 与r比较
            if (i + a[i] > r){
                r = i + a[i];
                c = i;
            }

            len = Math.max(len, a[i]);
        }
        return len - 1; // -1是因为预处理的数组, 每个原字符多了个#
    }

}
