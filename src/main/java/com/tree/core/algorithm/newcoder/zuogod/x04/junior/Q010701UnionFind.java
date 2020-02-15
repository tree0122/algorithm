package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

import java.util.HashMap;

/**
 * 并查集的意义:
 * 1. 快速查找两个元素是否是同一集合
 * 2. 快速合并两个集合
 */
public class Q010701UnionFind {

    HashMap<Node, Node> map = new HashMap<>();
    HashMap<Node, Integer> size = new HashMap<>();

    public boolean isSame(Node n1, Node n2){
        return head(n1) == head(n2);
    }

    public void union(Node n1, Node n2){
        Node h1 = head(n1);
        Node h2 = head(n2);
        if (h1 == h2){
            return;
        }
        Integer s1 = size.get(h1);
        Integer s2 = size.get(h2);
        if (s1 >= s2){
            map.put(h2, h1);
            size.put(h1, s1 + s2);
        }else {
            map.put(h1, h2);
            size.put(h2, s1 + s2);
        }
    }

    private Node head(Node node) {
        Node n1 = map.get(node);
        if (n1 != node){
            n1 = head(n1);
        }
        map.put(node, n1);
        return n1;
    }

    private class Node{

    }
}
