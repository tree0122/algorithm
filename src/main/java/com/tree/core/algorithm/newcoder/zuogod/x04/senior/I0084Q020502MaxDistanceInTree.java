package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * 二叉树中,一个节点可以往上走和往下走,那么从节点A总能走到节点B。
 *
 * 节点A走到节点B的距离为:A走到B最短路径上的节点个数。
 *
 * 求一棵二叉树上的最远距离
 */
public class I0084Q020502MaxDistanceInTree {

    public int maxDistance(Node head){
        return process(head)[1];
    }

    /**
     * 每个节点的情况
     *
     * @param node
     * @return a[0]表示高度, a[1]表示最远距离
     */
    public int[] process(Node node){
        int[] a = new int[2];
        if (node == null){
            return a;
        }
        int[] leftD = process(node.left);
        int[] rightD = process(node.right);
        a[0] = Math.max(leftD[0], rightD[0]) + 1;
        a[1] = Math.max(
                Math.max(leftD[1], rightD[1]),
                leftD[0] + rightD[0] + 1
        );
        return a;
    }

    private class Node{
        int val;
        Node left;
        Node right;
    }
}
