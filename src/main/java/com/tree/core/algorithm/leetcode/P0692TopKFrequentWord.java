package com.tree.core.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P0692TopKFrequentWord {

    public List<String> topKFrequent(String[] words, int k){
        if (words == null || words.length == 0 || k <= 0){
            return null;
        }
        HashMap<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>(k + 1,
                (s1, s2) -> !map.get(s1).equals(map.get(s2)) ? map.get(s1) - map.get(s2) : s2.compareTo(s1));
        for (String key : map.keySet()) {
            heap.offer(key);
            if (heap.size() == k + 1){
                heap.poll();
            }
        }
        List<String> list = new ArrayList<>(k);
        while (!heap.isEmpty()){
            list.add(heap.poll());
        }
        Collections.reverse(list);
        return list;
    }
    /*
    public List<String> topKFrequent(String[] words, int k){
        if (words == null || words.length == 0 || k <= 0){
            return null;
        }
        HashMap<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>(k, (s1, s2) -> !map.get(s1).equals(map.get(s2)) ? map.get(s1) - map.get(s2) : s2.compareTo(s1));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            String peek = heap.peek();
            if (heap.size() < k){
                heap.offer(key);
            }else if (value > map.get(peek)
                    || (value == map.get(peek) && key.compareTo(peek) > 0)
            ){
                heap.poll();
                heap.offer(key);
            }
        }
        String[] sa = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            sa[i] = heap.poll();
        }
        return Arrays.asList(sa);
    }*/

    @Test
    public void test(){
        String[] ss = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(ss, 2));
    }

}
