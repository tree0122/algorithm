package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1543 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution124 {
    public int maxPathSum(TreeNode root) {
        int[] res = path(root);
        return res[1];
    }

    private int[] path(TreeNode node) {
        int[] a = new int[2];
        if (node == null){
            return a;
        }
        int[] left = path(node.left);
        int[] right = path(node.right);
        int left0 = Math.max(left[0], 0);
        int right0 = Math.max(right[0], 0);
        a[0] = Math.max(left0, right0) + node.val;
        a[1] = Math.max(left0 + right0 + node.val, Math.max(left[1], right[1]));
        return a;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
