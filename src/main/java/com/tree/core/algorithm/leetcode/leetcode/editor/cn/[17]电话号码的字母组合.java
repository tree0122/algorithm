package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1858 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution17 {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        char[] cur = new char[digits.length()];
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        letterCombinations(digits, map, cur, 0, ans);
        return ans;
    }

    private void letterCombinations(String s, HashMap<Character, String> map, char[] cur, int i, List<String> ans) {
        if (i == s.length()){
            ans.add(new String(cur));
            return;
        }
        String vs = map.get(s.charAt(i));
        for (int j = 0; j < vs.length(); j++) {
            cur[i] = vs.charAt(j);
            letterCombinations(s, map, cur, i + 1, ans);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
