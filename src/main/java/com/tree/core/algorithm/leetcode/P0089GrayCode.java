package com.tree.core.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p>
 * Given a non-negative integer n representing the total number of bits in the code,
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 * <p>
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 */
public class P0089GrayCode {

    public List<Integer> grayCode(int n) {
        if (n == 0){
            return Arrays.asList(0);
        }
        if (n < 0){
            return new ArrayList<>();
        }
        List<Integer> list = grayCode(n - 1);
        List<Integer> a = new LinkedList<>(list);
        for (int i = list.size() - 1, b = 1 <<(n - 1); i >= 0; i--) {
            a.add(b + list.get(i));
        }
        return a;
    }

    public List<Integer> best(int n){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < ((int) Math.pow(2, n)); i++) {
            list.add((i >> 1) ^ i);
        }
        return list;
    }
    /*
    public List<Integer> grayCode(int n) {
        if (n < 0){
            return new ArrayList<>();
        }
        ArrayList<Integer> a = new ArrayList<>();
        p(n, 0, 0, a);
        return a;
    }*/

    private void p(int n, int i, int c, ArrayList<Integer> a) {
        if (i == n){
            a.add(c);
            return;
        }
        c = c << 1;
        p(n, i + 1, c, a);
        p(n, i + 1, c + 1, a);
    }

    @Test
    public void t(){
        List<Integer> list = best(3);
        System.out.println(list);
    }

}
