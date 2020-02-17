package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

import java.util.ArrayDeque;

/**
 * 单调栈
 *
 *
 * 单调栈实现一个数组的MaxTree
 *
 * Node{
 *     int value;
 *     Node left;
 *     Node right;
 * }
 *
 * 一个数组的MaxTree定义如下:
 * 1. 数组没有重复元素
 * 2. MaxTree是一个二叉树, 数组中的每个值对应一个二叉树的节点
 * 3. 包含MaxTree树在内, 在任何一棵子树上, 值最大的节点都是树的头
 *
 * 数组arr生成MaxTree的函数, 要求时间复杂度O(N), 空间复杂度O(N)
 */
public class I0072Q020301MaxTree {

    //todo
    public Node maxTree(int[] a){
        if (a == null || a.length == 0){
            return null;
        }

        Node[] nodes = new Node[a.length];
        for (int i = 0; i < a.length; i++) {
            nodes[i] = new Node(a[i]);
        }
        ArrayDeque<Node> stack = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && stack.peek().value < a[i]){
                Node node = stack.pop();
                Node pre = stack.peek();
                Node next = nodes[i];
                pre = pre == null ? next :
                        (pre.value < next.value ? pre : next);
                if (pre.left == null){
                   pre.left = node;
                }else {
                    pre.right = node;
                }
            }
            stack.push(nodes[i]);
        }
        while (stack.size() > 1){
            Node node = stack.pop();
            Node pre = stack.peek();
            if (pre.left == null){
                pre.left = node;
            }else {
                pre.right = node;
            }
        }
        return stack.pop();
    }

    private class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value = value;
        }
    }
        

}
