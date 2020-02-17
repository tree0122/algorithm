package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * 最小编辑代价
 *
 * 【题目】
 * 给定两个字符串str1和str2,再给定三个整数ic、dc和rc,分别代表插
 * 入、删除和替换一个字符的代价,返回将str1编辑成str2的最小代价。
 *
 * 【举例】
 * str1="abc",str2="adc",ic=5,dc=3,rc=2。
 * 从"abc"编辑成"adc",把'b'替换成'd'是代价最小的,所以返回2。
 * str1="abc",str2="adc",ic=5,dc=3,rc=100。
 * 从"abc"编辑成"adc",先删除'b',然后插入'd'是代价最小的,所以返回8。
 * str1="abc",str2="abc",ic=5,dc=3,rc=2。
 * 不用编辑了,本来就是一样的字符串,所以返回0。
 */
public class I0102Q020905LeastEditCost {

    public int awesome(String s1, String s2, int ic, int dc, int rc){
        if ((s1 == null || s1.length() == 0) && (s2 == null || s2.length() == 0)){
            return 0;
        }
        //dp[i][j]表示, s1(0...i)编辑成s2(0...j)的代价
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            //s1(0...i)编辑成 空串"" 的代价
            dp[i][0] = dc * i;
        }
        for (int i = 1; i < dp[0].length; i++) {
            //空串编辑成s2(0...i)的代价
            dp[0][i] = ic * i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + dc, dp[i][j - 1] + ic);
                dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - 1][j - 1] + s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : rc
                );
            }
        }
        return dp[s1.length()][s2.length()];
    }

}
