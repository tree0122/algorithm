package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1549 👎 0


import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0){
            return true;
        }
        for (String w : wordDict) {
            int i = s.indexOf(w);
            while (i != -1){
                if (wordBreak(s.substring(0, i) + s.substring(i + w.length()), wordDict)) {
                    return true;
                }
                i = s.indexOf(w, i);
            }
        }
        return false;
    }

    public boolean other(String s, Set<String> words){
        if (s.length() == 0){
            return true;
        }
        for (int i = 1; i < s.length() + 1; i++) {
            if (words.contains(s.substring(0, i))){
                if (other(s.substring(i), words)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dp(String s, List<String> words){
        HashSet<String> set = new HashSet<>(words);
        // d[i]表示s(0...i-1)是否可被拼接
        // d[i] == d[j] && check(j...i)
        boolean[] d = new boolean[s.length() + 1];
        d[0] = true;
        for (int i = 1; i < d.length; i++) {
            for (int j = 0; j < i; j++) {
                if (d[j] && set.contains(s.substring(j, i))){
                    d[i] = true;
                    break;
                }
            }
        }
        return d[d.length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
