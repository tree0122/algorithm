package com.tree.core.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 */
public class P0126WordLadder2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList); // 所有的单词集合
        Map<String, List<String>> neighborMap = new HashMap<>();// 每个单词对应的邻居
        Map<String, Integer> distanceMap = new HashMap<>();// 每个单词距离beginWord的距离
        List<String> solution = new ArrayList<>();

        dict.add(beginWord);
        bfs(beginWord, endWord, dict, neighborMap, distanceMap);
        dfs(beginWord, endWord, neighborMap, distanceMap, solution, res);
        return res;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, Set<String> dict,
                     Map<String, List<String>> neighborMap, Map<String, Integer> distanceMap) {
        for (String str : dict) {
            neighborMap.put(str, new ArrayList<>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distanceMap.put(start, 0);

        while (!queue.isEmpty()) {
            boolean foundEnd = false;
            int cn = queue.size(); // 当前字符串的邻居数量
            for (int i = 0; i < cn; i++) {
                String cur = queue.poll();
                int curDistance = distanceMap.get(cur);
                List<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    neighborMap.get(cur).add(neighbor);
                    if (!distanceMap.containsKey(neighbor)) {// Check if visited
                        distanceMap.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor)) {// Found the shortest path
                            foundEnd = true;
                        }else{
                            queue.offer(neighbor);
                        }
                    }
                }
            }

            if (foundEnd){
                break;
            }
        }
    }

    // Find all next level nodes.
    private List<String> getNeighbors(String node, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char chs[] = node.toCharArray();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char oldCh = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = oldCh;
            }

        }
        return res;
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, Map<String, List<String>> neighborMap,
                     Map<String, Integer> distanceMap, List<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<>(solution));
        } else {
            for (String next : neighborMap.get(cur)) {
                if (distanceMap.get(next) == distanceMap.get(cur) + 1) {
                    dfs(next, end, neighborMap, distanceMap, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }



    /*
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        LinkedHashMap<Integer, String> cur = new LinkedHashMap<>();
        cur.put(-1, beginWord);
        p(beginWord, endWord, wordList, 0, cur, ans);
        return ans;
    }

    private void p(String b, String e, List<String> w, int i, Map<Integer, String> c, List<List<String>> a) {
        if (b.equals(e)) {
            while (!a.isEmpty() && a.get(0).size() > c.size()){
                a.remove(a.size() - 1);
            }
            if (a.isEmpty() || a.get(0).size() == c.size()){
                a.add(new ArrayList<>(c.values()));
            }
            return;
        }
        if (i == w.size()) {
            return;
        }
        for (int k = 0; k < w.size(); k++) {
            if (c.containsKey(k)) {
                continue;
            }
            if (diff(b, w.get(k)) > 1) {
                continue;
            }
            c.put(k, w.get(k));
            p(w.get(k), e, w, i + 1, c, a);
            c.remove(k);
        }
    }

    private int diff(String s1, String s2) {
        int d = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                d++;
            }
        }
        return d;
    }*/

    @Test
    public void t() {
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        String beginWord = "qa";
        String endWord = "sq";
        List<String> wordList = Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye");
        List<List<String>> ladders = findLadders(beginWord, endWord, wordList);
        for (List<String> ladder : ladders) {
            System.out.println(ladder);
        }
    }

}
