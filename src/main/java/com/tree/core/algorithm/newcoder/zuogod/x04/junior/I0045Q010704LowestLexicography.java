package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

import java.util.PriorityQueue;

/**
 * 给定一个字符串类型的数组strs,找到一种拼接方式,使得把所
 * 有字 符串拼起来之后形成的字符串具有最低的字典序。
 */
public class I0045Q010704LowestLexicography {

    public String least(String[] a){
        if (a == null || a.length == 0){
            return null;
        }
        PriorityQueue<String> heap = new PriorityQueue<>((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        for (String s : a) {
            heap.offer(s);
        }
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()){
            sb.append(heap.poll());
        }
        return sb.toString();
    }

}
