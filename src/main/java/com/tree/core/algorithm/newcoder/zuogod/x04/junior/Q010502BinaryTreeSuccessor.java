package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 二叉树的后继和前驱
 */
public class Q010502BinaryTreeSuccessor {

    Node root = new Node();

    public Node successor(Node node){
        if (node == null){
            return null;
        }
        Node cur = node;
        if (node.right != null){
            cur = node.right;
            while (cur.left != null){
                cur = cur.left;
            }
            return cur;
        }
        while (cur.parent != null && cur.parent.left != cur){
            cur = cur.parent;
        }
        return cur.parent;
    }

    public Node precessor(Node node){
        if (node == null){
            return null;
        }
        Node cur = node;
        if (cur.left != null){
            cur = cur.left;
            while (cur.left != null){
                cur = cur.left;
            }
            return cur;
        }
        while (cur.parent != null && cur.parent.right != cur){
            cur = cur.parent;
        }
        return cur.parent;
    }

    public Node successorMorris(Node node){
        if (node == null){
            return null;
        }
        Node cur = root;
        Node mostRightInLeft = null;
        Node pre = null;
        while (cur != null){
            mostRightInLeft = cur.left;
            if (mostRightInLeft != null){
                while (mostRightInLeft.right != null && mostRightInLeft.right != cur){
                    mostRightInLeft = mostRightInLeft.right;
                }
                if (mostRightInLeft.right == null){
                    mostRightInLeft.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRightInLeft.right = null;
                }
            }
            if (pre == node){
                return cur;
            }
            pre = cur;
            cur = cur.right;
        }
        return null;
    }

    private class Node{
        int val;
        Node left;
        Node right;
        Node parent;
    }

}
