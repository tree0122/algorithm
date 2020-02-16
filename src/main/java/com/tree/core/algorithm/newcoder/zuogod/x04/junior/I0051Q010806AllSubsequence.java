package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有的子序列
 *
 * 基本概念:
 * 子序列 是不连续的
 * 子串 要求连续
 */
public class I0051Q010806AllSubsequence {

    public List<String> all(String s){
        if (s == null || s.length() == 0){
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        char[] cs = s.toCharArray();
        process(cs, 0, list);
        return list;
    }

    private void process(char[] cs, int i, ArrayList<String> list) {
        if (i == cs.length){
            list.add(String.valueOf(cs));
            return;
        }
        char t = cs[i];
        cs[i] = 0;
        process(cs, i + 1, list);
        cs[i] = t;
        process(cs, i + 1, list);
    }

}
