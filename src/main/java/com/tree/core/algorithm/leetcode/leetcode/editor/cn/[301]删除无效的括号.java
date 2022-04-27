package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
//
// 返回所有可能的结果。答案可以按 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()())()"
//输出：["(())()","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：s = "(a)())()"
//输出：["(a())()","(a)()()"]
// 
//
// 示例 3： 
//
// 
//输入：s = ")("
//输出：[""]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 25 
// s 由小写英文字母以及括号 '(' 和 ')' 组成 
// s 中至多含 20 个括号 
// 
// Related Topics 广度优先搜索 字符串 回溯 👍 712 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visitedSet = new HashSet<>();
        queue.offer(s);
        while (!queue.isEmpty()){
            s = queue.poll();
            if (valid(s)){
                ans.add(s);
            }
            if (ans.size() > 0){
                continue;
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' || s.charAt(i) != ')'){
                    continue;
                }
                s = s.substring(0, i) + s.substring(i + 1);
                if (visitedSet.add(s)){
                    queue.offer(s);
                }
            }
        }
        return ans;
    }

    private boolean valid(String s) {
        int delta = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                delta++;
            }else if (s.charAt(i) == ')'){
                delta--;
                if (delta < 0){
                    return false;
                }
            }
        }
        return delta == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
