package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * 括号问题
 *
 * 【题目】
 * 给定一个字符串str,判断是不是整体有效的括号字符串。
 *
 * 【举例】
 * str="()",返回true;str="(()())",返回true;str="(())",返回true。
 * str="())"。返回false;str="()(",返回false;str="()a()",返回false。
 *
 *
 * 【补充题目】
 * 给定一个括号字符串str,返回最长的有效括号子串。
 *
 * 【举例】
 * str="(()())",返回6;str="())",返回2;str="()(()()(",返回4。
 */
public class I0105Q020908ParenthesisQuestion {

    public boolean isValid(String s){
        if (s == null || s.length() == 0){
            return true;
        }

        int pair = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')'){
                return false;
            }
            if (s.charAt(i) == ')' && --pair < 0){
                return false;
            }
            if (s.charAt(i) == '('){
                pair++;
            }
        }
        return pair == 0;
    }

    public int awesome(String s){
        if (s == null || s.length() == 0){
            return 0;
        }

        int res = 0;
        //dp[i]表示, s(0...i)范围内 以s(i)结尾, 最长的有效括号子串
        int[] dp = new int[s.length()];
        for (int i = 1, pre = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && (pre = i - dp[i - 1] - 1) >= 0) {
                dp[i] = (dp[i - 1] + 2) + (pre > 0 ? dp[pre - 1] : 0);
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

}
