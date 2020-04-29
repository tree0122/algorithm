package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 八皇后问题
 * 国际象棋中, 8个皇后都在棋盘上的情况数量
 * 规则: 每个皇后的上下 左右 正反斜线方向, 都不可以放东西
 */
public class I0059Q011001EightQueen {

    public int best(int n){
        if (n < 1 || n > 32){
            return 0;
        }
        int upLim = n == 32 ? -1 : (1 << n) - 1;
        return bit(upLim, 0, 0, 0);
    }

    /**
     * 位运算方案, colLim表示列要求, leftLim表示左斜线要求, rightLim表示右斜线要求
     *
     * @param upLim     全局变量, 需要放置的皇后状态, 1可放 0不可放
     * @param colLim    截止到上一步, 已放置的皇后, 会影响的列位置状态, 1受影响 0不受影响
     * @param leftLim   截止到上一步, 已放置的皇后, 会影响的左下状态, 1受影响 0不受影响
     * @param rightLim  截止到上一步, 已放置的皇后, 会影响的右下状态, 1受影响 0不受影响
     * @return 在已放置的皇后状态下, 剩余皇后可摆放的组合情况数
     */
    private int bit(int upLim, int colLim, int leftLim, int rightLim){
        if (upLim == colLim){
            return 1;
        }
        int res = 0;
        // 当前行可放置的情况, 1可放 0不可
        int pos = upLim & (~(colLim | leftLim | rightLim));
        // pos的最右边为1的情况, 即最右边可放皇后的位置
        int mostRightOne = 0;
        while (pos != 0){
            mostRightOne = pos & (-pos);
            res += bit(
                    upLim,
                    colLim | mostRightOne,
                    (leftLim | mostRightOne) << 1,
                    (rightLim | mostRightOne) >>> 1
            );
        }
        return res;
    }


    public int count(int[] a){
        if (a == null || a.length == 0){
            return 0;
        }
        return process(a, 0);
    }

    /**
     * 直接方法
     *
     * @param a 皇后放置情况, (i, a[i])表示第i行第a[i]列 放一个皇后
     * @param i 处理第index皇后, 潜台词: (index -1)个皇后已按要求放置
     * @return 第index皇后按要求放置的情况数
     */
    private int process(int[] a, int i) {
        if (i == a.length){
            return 1;
        }
        int ans = 0;
        for (int k = 1; k <= a.length; k++) {
            if (valid(a, i, k)){
                a[i] = k;
                ans += process(a, i + 1);
            }
        }
        return ans;
    }

    /**
     * 是否可将第index皇后, i val列位置
     * @param a 皇后放置情况
     * @param i 处理第index皇后, 潜台词: (i -1)个皇后已按要求放置
     * @param val 尝试将此皇后放在val列
     * @return 可放true, 不可false
     */
    private boolean valid(int[] a, int i, int val) {
        for (int k = 0; k < i; k++) {
            if (a[k] == val || Math.abs(k - i) == Math.abs(a[k] - val)){
                return false;
            }
        }
        return true;
    }

}
