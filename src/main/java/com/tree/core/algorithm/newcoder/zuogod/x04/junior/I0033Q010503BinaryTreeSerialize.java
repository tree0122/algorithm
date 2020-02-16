package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

import java.util.ArrayDeque;

/**
 * 二叉树的序列化和反序列化
 */
public class I0033Q010503BinaryTreeSerialize {

    public String serializeByPre(Node node){
        if (node == null){
            return "#,";
        }
        String s = node.val + ",";
        String l = serializeByPre(node.left);
        String r = serializeByPre(node.right);
        return s + l + r;
    }

    public Node re(String s){
        String[] ss = s.split(",");
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String s1 : ss) {
            queue.offer(s1);
        }
        return recon(queue);
    }

    private Node recon(ArrayDeque<String> queue) {
        String s = queue.poll();
        if (s == "#"){
            return null;
        }
        Node node = new Node(Integer.parseInt(s));
        node.left = recon(queue);
        node.right = recon(queue);
        return node;
    }

    public String serilizeByLevel(Node node){
        if (node == null){
            return "#,";
        }
        String s = node.val + ",";
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        Node cur = null;
        while (!queue.isEmpty()){
            cur = queue.poll();
            if (cur.left == null){
                s += "#,";
            }else {
                s += cur.left.val + ",";
                queue.offer(cur.left);
            }
            if (cur.right == null){
                s += "#,";
            }else {
                s += cur.right.val + ",";
                queue.offer(cur.right);
            }
        }
        return s;
    }

    public Node reByLevel(String s){
        if (s == null){
            return null;
        }
        String[] ss = s.split(",");
        int i = 0;
        Node head = gen(ss[i++]);
        if (head == null){
            return null;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(head);
        Node cur = null;
        while (!queue.isEmpty()){
            cur = queue.poll();
            cur.left = gen(ss[i++]);
            if (cur.left != null){
                queue.offer(cur.left);
            }
            cur.right = gen(ss[i++]);
            if (cur.right != null){
                queue.offer(cur.right);
            }
        }
        return head;
    }

    private Node gen(String s) {
        if ("#".equals(s)){
            return null;
        }
        return new Node(Integer.parseInt(s));
    }

    private class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }

}
