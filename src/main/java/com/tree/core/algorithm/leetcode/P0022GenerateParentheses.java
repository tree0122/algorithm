package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class P0022GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        if (n < 1){
            return list;
        }
        process(list, "", 0, 0, n);
        return list;
    }

    private void process(List<String> list, String cur, int open, int close, int max) {
        if (cur.length() == max * 2){
            list.add(cur);
            return;
        }
        if (open < max){
            process(list, cur + "(", open + 1, close, max);
        }
        if (close < open){
            process(list, cur + ")", open, close + 1, max);
        }
    }

    public List<String> gen(int n){
        ArrayList<String> list = new ArrayList<>();
        if (n == 0){
            list.add("");
        }else {
            for (int i = 0; i < n; i++) {
                for (String left : gen(i)) {
                    for (String right : gen(n - 1 - i)) {
                        list.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return list;
    }


}
