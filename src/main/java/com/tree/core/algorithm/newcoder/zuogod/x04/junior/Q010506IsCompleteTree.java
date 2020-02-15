package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

import java.util.ArrayDeque;

/**
 * 是否为完全二叉树
 *
 * 思路:
 * 1. 利用队列, 逐层遍历
 * 2. 某个树, 左空右不空, 为false
 * 3. 某个树的叶子开始为空, 则后面的叶子都必须空, 否则false
 */
public class Q010506IsCompleteTree {

    public boolean isC(Node node){
        if (node == null){
            return true;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        Node cur = null;
        Node l = null;
        Node r = null;
        boolean leaf = false;
        while (!queue.isEmpty()){
            cur = queue.poll();
            l = cur.left;
            r = cur.right;
            if (l == null && r != null){
                return false;
            }
            if (leaf && (l != null || r != null)){
                return false;
            }
            if (l != null){
                queue.offer(l);
            }
            if (r != null){
                queue.offer(r);
            }else {
                leaf = true;
            }
        }
        return true;
    }

    private class Node{
        Node left;
        Node right;
    }

}
