package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1685 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int min = Integer.MAX_VALUE, distance = 0, left = 0;
        String res = "";
        for (int right = 0; right < s.length(); right++) {
            Integer co = map.get(s.charAt(right));
            if (co != null){
                map.put(s.charAt(right), co - 1);
                if (co > 0){
                    distance++;
                }
            }
            while (distance == t.length()){
                if (min > right -left + 1 ){
                    min = right - left + 1;
                    res = s.substring(left, right);
                }
                Integer c = map.get(s.charAt(left));
                if (c != null){
                    map.put(s.charAt(left), c + 1);
                    if (c == 0){
                        distance--;
                    }
                }
                left++;
            }
        }
        return res;
    }

    public String better(String s, String t){
        char[] sa = s.toCharArray(); // s的数组表示
        char[] ta = t.toCharArray(); // t的数组表示
        int[] winFreq = new int[128]; // 遍历s时，滑动窗口中对于的字符及其字符个数
        int[] tFreq = new int[128]; // t的字符及其字符个数
        for (char c : ta) {
            tFreq[c]++;
        }

        int minLen = s.length() + 1;
        int begin = 0;
        int distance = 0; // 窗口内包含t的所有字符的个数，如果某个字符数量超过t中对于字符，distance不增加
        int left = 0; // 窗口左边界
        int right = 0; // 窗口右边界
        // 窗口区间为 [left, right)，左闭右开：right左边的元素都是程序可见
        while (right < sa.length){
            if (tFreq[sa[right]] == 0){
                right++;
                continue;
            }
            if (winFreq[sa[right]] < tFreq[sa[right]]){
                distance++;
            }
            winFreq[sa[right]]++;
            right++;

            while (distance == ta.length){
                if (minLen < right - left){
                    minLen = right - left;
                    begin = left;
                }
                if (tFreq[sa[left]] == 0){
                    left++;
                    continue;
                }
                if (winFreq[sa[left]] == tFreq[sa[left]]){
                    distance--;
                }
                winFreq[sa[left]]--;
                left++;
            }
        }
        if (minLen == sa.length + 1){
            return "";
        }
        return s.substring(begin, begin + minLen);
    }

    public String best(String s, String t){
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        int[] tFreq = new int[128]; // 窗口内满足t, 还需要的字符和对于字符数量
        for (char c : ta) {
            tFreq[c]++;
        }
        int distance = ta.length; // 窗口内满足t, 还需要的总字符数
        int left = 0;
        int right = 0;
        int begin = 0;
        int minLen = sa.length + 1;
        while (right < sa.length){
            if (tFreq[sa[right]] > 0){
                distance--;
            }
            tFreq[sa[right]]--;
            right++;

            while (distance == 0){
                if (minLen < right - left){
                    minLen = right -left;
                    begin = left;
                }
                if (tFreq[sa[left]] == 0){
                    distance++;
                }
                tFreq[sa[left]]++;
                left++;
            }
        }
        if (minLen == sa.length + 1){
            return "";
        }
        return s.substring(begin, begin + minLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
