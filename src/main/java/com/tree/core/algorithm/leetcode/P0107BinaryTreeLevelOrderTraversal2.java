package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class P0107BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> ans = new ArrayList<>();
        process(root, 0, ans);
        Collections.reverse(ans);
        return ans;
    }

    private void process(TreeNode node, int h, ArrayList<List<Integer>> list) {
        if (node == null){
            return;
        }
        if (h == list.size()){
            list.add(new ArrayList<>());
        }
        list.get(h).add(node.val);
        if (node.left != null){
            process(node.left, h + 1, list);
        }
        if (node.right != null){
            process(node.right, h+ 1, list);
        }
    }

    /**
     * queue遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> traversal(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
        LinkedList<List<Integer>> ans = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> levelData = new ArrayList<>(); // 某一层的结点数据
        TreeNode tmpNode = null;
        // i是某一层的结点个数
        for (int i = queue.size(); !queue.isEmpty(); ) {
            if (i == 0){
                ans.addFirst(levelData);
                levelData = new ArrayList<>();
                i = queue.size();
            }
            tmpNode = queue.poll();
            levelData.add(tmpNode.val);
            i--;
            if (tmpNode.left != null){
                queue.offer(tmpNode.left);
            }
            if (tmpNode.right != null){
                queue.offer(tmpNode.right);
            }
        }
        return ans;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

}
