package com.tree.core.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 编写一段程序来查找第 n 个超级丑数。
 *
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 *
 * 示例:
 *
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 说明:
 *
 * 1 是任何给定 primes 的超级丑数。
 *  给定 primes 中的数字以升序排列。
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
 * 第 n 个超级丑数确保在 32 位有符整数范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P0313SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes){
        if (n < 0 || primes == null || primes.length == 0){
            return 0;
        }
        int[] d = new int[n];
        d[0] = 1;
        int[] t = new int[primes.length];
        PriorityQueue<int[]> heap = new PriorityQueue<>(primes.length, Comparator.comparingInt(i1 -> i1[0]));
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < primes.length; j++) {
                heap.offer(new int[]{primes[j] * d[t[j]], j});
            }
            int[] min = heap.poll();
            t[min[1]]++;
            while (!heap.isEmpty() && heap.peek()[0] == min[0]){
                t[heap.poll()[1]]++;
            }
            heap.clear();
            d[i] = min[0];
        }
        return d[n - 1];
    }

}
