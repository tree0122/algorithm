package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 10⁵ 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1229 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses]; // 图的每个节点的入度
        List<List<Integer>> adjacency =  new ArrayList<>(numCourses); // 图的每个节点的临近节点
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int indegree : indegrees) {
            if (indegree == 0){
                queue.offer(indegree);
            }
        }
        while (!queue.isEmpty()){
            numCourses--;
            Integer p = queue.poll();
            for (Integer adj : adjacency.get(p)) {
                if (--indegrees[adj] == 0){
                    queue.offer(adj);
                }
            }
        }
        return numCourses == 0;
    }

    public boolean can(int n, int[][] prerequisites){
        int[] flags = new int[n];
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adjacency.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < n; i++) {
            if (!dfs(adjacency, flags, i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1){
            return false;
        }
        if (flags[i] == -1){
            return true;
        }
        flags[i] = 1;
        for (Integer adj : adjacency.get(i)) {
            if (!dfs(adjacency, flags, adj)){
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
