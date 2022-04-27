package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1547 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

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
class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], 0);
        }
        return buildTree(preorder, 0, preorder.length - 1, inMap, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preOrder, int preLeft, int preRight, Map<Integer, Integer> inMap, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight){
            return null;
        }
        TreeNode node = new TreeNode(preOrder[preLeft]);
        int inIdx = inMap.get(preOrder[preLeft]);
        node.left = buildTree(preOrder, preLeft + 1, preLeft + inIdx - inLeft, inMap, inLeft, inIdx - 1);
        node.right = buildTree(preOrder, preLeft + inIdx - inLeft + 1, preRight, inMap, inIdx + 1, inRight);
        return node;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
