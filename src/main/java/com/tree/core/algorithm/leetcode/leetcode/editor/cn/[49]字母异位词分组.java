package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 排序 👍 1027 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        if (strs == null || strs.length == 0){
            return res;
        }
        HashMap<Set<Character>, List<String>> map = new HashMap<>();
        for (String s : strs) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }
            List<String> list = map.get(set);
            if (list == null){
                list = new LinkedList<>();
                map.put(set, list);
            }
            list.add(s);
        }
        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
