package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 汉诺塔问题
 */
public class Q010805Hanoi {

    public void hanoi(String from, String to, String help, int n){
        hanoi(from, help, to, n - 1);
        System.out.println("from -> to: 第" + n);
        hanoi(help, to, from, n - 1);
    }

}
