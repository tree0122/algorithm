package com.tree.core.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note:
 * <p>
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 * <p>
 * Input: n = 3, k = 3
 * Output: "213"
 */
public class P0060PermutationSequence {

    public String best(int n, int k) {
        // get factorial array
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        // generate nums 1 to n
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        // get the permutation digit
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // k begins from 1, so (1, 2) is a group
            int rank = (k - 1) / fact[n - i - 1];
            k = (k - 1) % fact[n - i - 1] + 1;
            // ajust the mapping of rank to num
            sb.append(nums.get(rank));
            nums.remove(nums.get(rank));
        }

        return sb.toString();
    }


    public String getPermutation(int n, int k) {
        char[] a = new char[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (i + '1');
        }
        List<String> list = new ArrayList<>();
        List<Character> c = new ArrayList<>();
        boolean[] v = new boolean[n];
        p(a, 0, v, c, list);
        return list.get(k - 1);
    }

    /**
     * 全排列过程
     * @param a 源数组
     * @param i 当前元素个数
     * @param v 处理过的元素数组
     * @param c 当前字符集
     * @param list
     */
    private void p(char[] a, int i, boolean[] v, List<Character> c, List<String> list) {
        if (i == a.length) {
            StringBuilder sb = new StringBuilder();
            for (Character ch : c) {
                sb.append(ch);
            }
            list.add(sb.toString());
            return;
        }
        for (int k = 0; k < a.length; k++) {
            if (v[k]) {
                continue;
            }
            c.add(a[k]);
            v[k] = true;
            p(a, i + 1, v, c, list);
            c.remove(c.size() - 1);
            v[k] = false;
        }
    }

    @Test
    public void test() {
        System.out.println(getPermutation(3, 5));
    }

}
