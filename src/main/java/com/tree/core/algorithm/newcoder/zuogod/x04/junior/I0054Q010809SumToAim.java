package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 一个数组a和一个整数aim. 简单情况下 数组a中所有元素都是正数
 * 任意选择a中的数字, 能不能累加得到aim,
 * 可以返回true, 否则false
 */
public class I0054Q010809SumToAim {

    public boolean best(int[] a, int aim){
        if (a == null || a.length == 0){
            return false;
        }
        boolean[] d = new boolean[aim + 1];
        d[0] = true;
        for (int i = a.length - 2; i >= 0; i--) {
            for (int j = 0; j <= aim; j++) {
                if (d[j]){
                    continue;
                }
                int next = j - a[i];
                if (next >= 0 && next <= aim){
                    d[j] = d[j] || d[next];
                }
            }
        }
        return d[aim];
    }

    public boolean can(int[] a, int aim){
        if (a == null || a.length == 0){
            return false;
        }
        return process(a, aim, 0);
    }

    private boolean process(int[] a, int aim, int i) {
        if (i == a.length){
            return aim == 0;
        }
        return process(a, aim, i + 1) || process(a, aim - a[i], i + 1);
    }

}
