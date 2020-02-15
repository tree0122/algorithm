package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 一只母牛每年生一只母牛, 新出生的母牛三年后也能每年生一只母牛.
 * 假设牛不会死, N年后一共有多少只牛
 *
 * f(n) = f(n-1) + f(n-3)
 */
public class Q010807Cow {

    public int count(int n){
        if (n < 4){
            return n;
        }
        return count(n - 1) + count(n - 3);
    }

    public int dp(int n){
        if (n < 4){
            return n;
        }
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 0;
        for (int i = 4; i <= n; i++) {
            d = c + a;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }

}
