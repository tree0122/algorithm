package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

import java.util.ArrayDeque;

/**
 * 二叉树的遍历(递归和非递归)
 */
public class I0031Q010501BinaryTreeTraversal {

    public void in(Node node){
        if (node == null){
            return;
        }
        in(node.left);
        System.out.println(node.val);
        in(node.right);
    }

    public void pre(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.val);
        pre(node.left);
        pre(node.right);
    }

    public void post(Node node){
        if (node == null){
            return;
        }
        post(node.left);
        post(node.right);
        System.out.println(node.val);
    }

    public void inNo(Node node){
        if (node == null){
            return;
        }
        Node cur = node;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }

    public void preNo(Node node){
        if (node == null){
            return;
        }
        Node cur = node;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(cur);
        while (!stack.isEmpty()){
            cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    public void postNo(Node node){
        if (node == null){
            return;
        }
        Node cur = node;
        ArrayDeque<Node> stack1 = new ArrayDeque<>();
        ArrayDeque<Node> stack2 = new ArrayDeque<>();
        stack1.push(cur);
        while (!stack1.isEmpty()){
            cur = stack1.pop();
            stack2.push(cur);
            if (cur.left != null){
                stack1.push(cur.left);
            }
            if (cur.right != null){
                stack1.push(cur.right);
            }
        }
        while (!stack2.isEmpty()){
            System.out.println(stack2.pop().val);
        }
    }

    public void morrisIn(Node node){
        if (node == null){
            return;
        }
        Node cur = node;
        Node mostRightInLeft = null;
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
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    public void morrisPre(Node node){
        if (node == null){
            return;
        }
        Node cur = node;
        Node mostRightInLeft = cur;
        while (cur != null){
            mostRightInLeft = cur.left;
            if (mostRightInLeft != null){
                while (mostRightInLeft.right != null && mostRightInLeft.right != cur){
                    mostRightInLeft = mostRightInLeft.right;
                }
                if (mostRightInLeft.right == null){
                    System.out.println(cur.val);
                    mostRightInLeft.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRightInLeft.right = null;
                }
            }else {
                System.out.println(cur.val);
            }
            cur = cur.right;
        }
    }

    private class Node{
        int val;
        Node left;
        Node right;
    }

}
