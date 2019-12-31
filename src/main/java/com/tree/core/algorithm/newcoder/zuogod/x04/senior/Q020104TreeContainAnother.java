package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * KMP的应用
 *
 * 两颗树T1和T2, T2是不是T1的子树
 */
public class Q020104TreeContainAnother {

    public boolean contains(Node n1, Node n2){
        String s1 = serialize(n1);
        String s2 = serialize(n2);
        if (s1.length() < s2.length()){
            String t = s1;
            s1 = s2;
            s2 = t;
        }
        int cn = 0;
        int[] a = new int[s2.length()];
        a[0] = -1;
        for (int i = 2; i < s2.length();) {
            if (s2.charAt(i - 1) == s2.charAt(cn)){
                a[i++] = ++cn;
            }else if (cn > 0){
                cn = a[cn];
            }else {
                i++;
            }
        }
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()){
            if (s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else if (j > 0){
                j = a[j];
            }else {
                i++;
            }
        }
        return j == s2.length();
    }

    private String serialize(Node node) {
        if (node == null){
            return "#,";
        }
        String s = node.value + ",";
        s += serialize(node.left);
        s += serialize(node.right);
        return s;
    }

    private class Node{
        int value;
        Node left;
        Node right;
    }

}
