package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 阿里的一个面试题
 *
 * 在1-N步路, 一个机器人可以走P步, 其初始位置M, 走到目标是K位置的方法数
 * 注意: 1位置, 只能往右走; N位置只能往左走
 *
 */
public class I0055Q010901RobotWay {

    public int best(int range, int rest, int init , int aim){
        if (range < 1 || rest < 1 || init < 1 || init > range || aim < 1 || aim > range){
            return 0;
        }
        int[] d = new int[range + 1];
        d[init] = 1;
        for (int i = 1; i <= rest; i++) {
            for (int j = 0; j < d.length; j++) {
                if (j == 0){
                    d[j] = d[j + 1];
                }else if (j == d.length - 1){
                    d[j] = d[j - 1];
                }else {
                    d[j] = d[j - 1] + d[j + 1];
                }
            }
        }
        return d[init];
    }


    public int way(int range, int rest, int init, int aim){
        if (range < 1 || rest < 1 || init < 1 || init > range || aim < 1 || aim > range){
            return 0;
        }
        if (rest == 0){
            return init == aim ? 1 : 0;
        }
        if (init == 1){
            return way(range, rest - 1, init + 1, aim);
        }
        if (init == range){
            return way(range, rest - 1, init - 1, aim);
        }
        return way(range, rest - 1, init + 1, aim)
                + way(range, rest - 1, init - 1, aim);
    }

}
