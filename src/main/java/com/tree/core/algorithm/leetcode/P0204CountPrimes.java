package com.tree.core.algorithm.leetcode;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class P0204CountPrimes {

    public int countPrimes(int n){
        if (n <= 1){
            return 0;
        }
        int cnt = 0;
        boolean[] primes = new boolean[n];
        for (int i = 0; i < n; i++) {
            primes[i] = true;
        }
        for (int i = 2; i < n; i++) {
            if (!primes[i]){
                continue;
            }
            cnt++;
            for (int j = 2; j * i < n; j++) {
                primes[i * j] = false;
            }
        }
        return cnt;
    }


}
