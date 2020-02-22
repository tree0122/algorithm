package com.tree.core.algorithm.leetcode;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P0451SortCharByFrequency {

    public String frequencySort(String s){
        if (s == null || s.length() == 0){
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>(s.length());
        PriorityQueue<int[]> heap = new PriorityQueue<>(s.length(), (n1, n2) -> n2[1] - n1[1]);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        char[] cs = new char[s.length()];
        int i = 0;
        while (!heap.isEmpty()){
            int[] p = heap.poll();
            while (p[1] > 0){
                cs[i++] = (char) p[0];
                p[1]--;
            }
        }
        return String.valueOf(cs);
    }

    @Test
    public void test(){
        System.out.println(frequencySort("tree"));
    }

}
