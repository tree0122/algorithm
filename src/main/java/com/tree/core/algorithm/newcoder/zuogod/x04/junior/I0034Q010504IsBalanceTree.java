package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 是否为平衡二叉树
 *
 * 学术中的概念: 树型dp
 *
 * 思路:
 * 1. 处理每个子树的情况
 * 2. 收集每个子树的左树 右树 (树的高度, 是否平衡)
 * 3. 根据当前节点 左树 右树的收集数据, 进行决策
 */
public class I0034Q010504IsBalanceTree {

    public boolean isB(Node node){
        return height(node) >= 0;
    }

    private int height(Node node) {
        if (node == null){
            return 0;
        }
        int l = height(node.left);
        if (l < 0){
            return -1;
        }
        int r = height(node.right);
        if (r < 0){
            return -1;
        }
        if (Math.abs(l - r) > 1){
            return -1;
        }
        return Math.max(l, r) + 1;
    }

    private class Node{
        Node left;
        Node right;
    }

}
