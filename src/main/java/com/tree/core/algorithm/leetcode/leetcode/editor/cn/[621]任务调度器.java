package com.tree.core.algorithm.leetcode.leetcode.editor.cn;
//给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个
//单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。 
//
// 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。 
//
// 你需要计算完成所有任务所需要的 最短时间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：tasks = ["A","A","A","B","B","B"], n = 2
//输出：8
//解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
//     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。 
//
// 示例 2： 
//
// 
//输入：tasks = ["A","A","A","B","B","B"], n = 0
//输出：6
//解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
//["A","A","A","B","B","B"]
//["A","B","A","B","A","B"]
//["B","B","B","A","A","A"]
//...
//诸如此类
// 
//
// 示例 3： 
//
// 
//输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
//输出：16
//解释：一种可能的解决方案是：
//     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待
//命) -> (待命) -> A
// 
//
// 
//
// 提示： 
//
// 
// 1 <= task.length <= 10⁴ 
// tasks[i] 是大写英文字母 
// n 的取值范围为 [0, 100] 
// 
// Related Topics 贪心 数组 哈希表 计数 排序 堆（优先队列） 👍 840 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>(tasks.length);
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0)  + 1);
        }
        PriorityQueue<Character> heap = new PriorityQueue<>((e1, e2) -> map.get(e2) - map.get(e1));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            heap.offer(entry.getKey());
        }
        int res = 0;
        LinkedList<Character> stack = new LinkedList<>();
        while (!heap.isEmpty()){
            int stackSize = 0; // 当前分块的大小
            while (!heap.isEmpty() && stack.size() < n + 1){
                stack.push(heap.poll());
                stackSize++;
            }
            while (!stack.isEmpty()){
                Character c = stack.pop();
                Integer cn = map.get(c);
                map.put(c, cn - 1);
                if (cn > 1){
                    heap.offer(c);
                }
            }
            // 此时，如果heap为空，则所以没有下一次的分块任务，故需要当前分块的大小
            res += heap.isEmpty() ? stackSize : n + 1;
        }
        return res;
    }

    public int better(char[] ts, int n){
        if (n == 0){ // n = 0 ，表示不考虑冷却时间
            return ts.length;
        }
        HashMap<Character, Integer> map = new HashMap<>(ts.length); // 统计每个task的个数
        int maxTimes = 0; // 出现次数最多的task
        int maxTimesTaskSize = 0; // 出现次数为maxTimes的task数量
        for (char t : ts) {
            int cn = map.getOrDefault(t, 0) + 1;
            map.put(t, cn);
            maxTimes = Math.max(maxTimes, cn);
        }
        if (maxTimes == 1){
            return ts.length;
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxTimes){
                maxTimesTaskSize++;
            }
        }
        return (n + 1) * (maxTimes - 1) + maxTimesTaskSize;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
