package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2583 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(n, new StringBuilder(), 0, 0, ans);
        return ans;
    }

    private void backtrack(int n, StringBuilder cur, int left, int right, List<String> ans) {
        if (n * 2 == cur.length()){
            ans.add(cur.toString());
            return;
        }
        if (left < n){
            cur.append('(');
            backtrack(n, cur, left + 1, right, ans);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right < left){
            cur.append(')');
            backtrack(n, cur, left, right + 1, ans);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public List<String> right(int n){
        ArrayList<String> ans = new ArrayList<>();
        right(0, new char[n * 2], ans);
        return ans;
    }

    private void right(int i, char[] tmp, List<String> ans) {
        if (i == tmp.length){
            if (check(tmp)){
                ans.add(new String(tmp));
            }
            return;
        }
        tmp[i] = '(';
        right(i + 1, tmp, ans);
        tmp[i] = ')';
        right(i + 1, tmp, ans);
    }

    private boolean check(char[] a) {
        int cn = 0;
        for (char c : a) {
            if (c == '('){
                cn ++;
            }else {
                cn--;
            }
            if (cn < 0){
                return false;
            }
        }
        return cn == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
