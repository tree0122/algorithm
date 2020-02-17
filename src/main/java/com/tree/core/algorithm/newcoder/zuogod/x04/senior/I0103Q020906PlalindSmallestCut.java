package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * 回文最小分割数
 *
 * 【题目】
 * 给定两个字符串str,请把str切割,保证每一部分都是回文串,求最小的分割
 * 数。
 *
 * 【举例】
 * str="AA12321BB",切成"AA","12321","BB",每一部分都是回文串,分出3个
 * 部分,所以返回3
 */
public class I0103Q020906PlalindSmallestCut {
   
    public int awesome(String s){
        if (s == null || s.length() == 0){
            return 0;
        }
        if (s.length() == 2){
            return s.charAt(0) == s.charAt(1) ? 1 : 2;
        }
        //dp[i]表示，s(i...len)切分成回文串的最小切割数
        int[] dp = dp(s);
        return dp[0];
    }

    private int[] dp(String s) {
        //ans[i]表示，s(i...len)切分成回文串的最小切割数
        int[] ans = new int[s.length()];
        ans[ans.length - 1] = 1;
        boolean[][] isPa = pdp(s);
        for (int i = ans.length - 2; i > 0; i--) {
            ans[i] = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                if (isPa[i][j] && ans[j + 1] + 1 < ans[i]){
                    ans[i] = ans[j + 1] + 1;
                }
            }
        }
        return ans;
    }

    private boolean[][] pdp(String s) {
        //ans[i][j]表示，s[i...j]是否是回文串
        boolean[][] ans = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            ans[i][i] = true;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                ans[i][j] = s.charAt(i) == s.charAt(j) && ans[i + 1][j - 1];
            }
        }
        return ans;
    }
    
}
