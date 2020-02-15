package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 完全二叉树的节点个数
 */
public class Q010507CompleteTreeCount {

    public int count(Node node){
        if (node == null){
            return 0;
        }
        return bs(node, 1, depth(node, 1));
    }

    private int bs(Node node, int level, int depth) {
        if (level == depth){
            return 1;
        }
        if (depth(node.right, level + 1) == depth){
            return (1 << (depth - level)) + bs(node.right, level + 1, depth);
        }else {
            return (1 << (depth - level - 1)) + bs(node.left, level + 1, depth);
        }
    }

    private int depth(Node node, int i) {
        while (node.left != null){
            i++;
            node = node.left;
        }
        return i;
    }

    private class Node{
        Node left;
        Node right;
    }

}
