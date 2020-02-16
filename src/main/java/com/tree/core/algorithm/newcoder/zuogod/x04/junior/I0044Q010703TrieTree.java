package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 介绍前缀树
 * 何为前缀树? 如何生成前缀树?
 * 例子:
 * 一个字符串类型的数组arr1,另一个字符串类型的数组arr2.
 *
 * arr2中有哪些字符,是arr1中出现的?请打印
 *
 * arr2中有哪些字符,是作为arr1中某个字符串前缀出现的?请打印
 *
 * arr2中有哪些字符,是作为arr1中某个字符串前缀出现的?请打印
 * arr2中出现次数最大的前缀.
 */
public class I0044Q010703TrieTree {

    Node root = new Node();

    public void insert(String s){
        if (s == null || s.length() == 0){
            return;
        }
        Node cur = this.root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (cur.next[idx] == null){
                cur.next[idx] = new Node();
            }
            cur.next[idx].path++;
            cur = cur.next[idx];
        }
        cur.end++;
    }

    public int select(String s){
        if (s == null || s.length() == 0){
            return -1;
        }
        Node cur = this.root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (cur.next[idx] == null) {
                return 0;
            }
            cur = cur.next[idx];
        }
        return cur.end;
    }

    public int prefix(String s){
        if (s == null || s.length() == 0){
            return -1;
        }
        Node cur = this.root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (cur.next[idx] == null){
                return 0;
            }
            cur = cur.next[idx];
        }
        return cur.path;
    }

    public void remove(String s){
        if (select(s) < 1){
            return;
        }
        Node cur = this.root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (--cur.next[idx].path == 0){
                cur.next[idx] = null;
                return;
            }
            cur = cur.next[idx];
        }
        cur.end--;
    }

    private class Node{
        int path;
        int end;
        Node[] next = new Node[26];
    }

}
