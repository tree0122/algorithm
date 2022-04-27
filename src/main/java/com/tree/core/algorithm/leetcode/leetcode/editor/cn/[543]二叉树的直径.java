package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 深度优先搜索 二叉树 👍 942 👎 0


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
class Solution543 {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] r = path(root);
        return r[0];
    }

    private int[] path(TreeNode node) {
        int[] a = {0,0};
        if (node == null){
            return a;
        }
        int[] l = path(node.left);
        int[] r = path(node.right);
        a[1] = Math.max(l[1], r[1]) + 1;
        a[0] = Math.max(l[1] + r[1] + 1, Math.max(l[0], l[0]));
        return a;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
