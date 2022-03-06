package com.tree.core.algorithm.leetcode.leetcode.editor.cn;
//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 👍 1678 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;

class Solution32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>(); // stack一直放入'('字符的索引
        int b = 0, // b表示当前最长有效字符串的起始位置
                res = 0,
                len = 0; // 每个有效字符串的长度
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    b = i + 1;
                } else {
                    stack.pop();
                    len = stack.isEmpty() ? i - b + 1 : i - stack.peek();
                    res = Math.max(res, len);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
