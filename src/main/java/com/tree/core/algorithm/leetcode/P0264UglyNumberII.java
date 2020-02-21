package com.tree.core.algorithm.leetcode;

import org.junit.Test;

/**
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 */
public class P0264UglyNumberII {

    public int nthUglyNumber(int n){
        if (n < 0){
            return 0;
        }
        int[] d = new int[n];
        d[0] = 1;
        for (int i = 1, j = 0, k = 0, p = 0; i < n; i++) {
            int min = Math.min(d[j] * 2, Math.min(d[k] * 3, d[p] * 5));
            if (min == d[j] * 2){ //d[j] * 2, d[k] * 3, d[p] * 5, 三个数有可能相等
                j++;
            }
            if (min == d[k] * 3){
                k++;
            }
            if (min == d[p] * 5){
                p++;
            }
            d[i] = min;
        }
        return d[n - 1];
    }

    @Test
    public void test(){
        System.out.println(nthUglyNumber(10));
    }

}
