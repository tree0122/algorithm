package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * TSP问题（Traveling Salesman Problem, 旅行商问题）, 由威廉哈密顿爵士和英国数学家克克曼T.P.Kirkman于19世纪初提出.
 *
 * 问题描述如下：
 * 有若干个城市, 任何两个城市之间的距离都是确定的, 现要求一旅行商从某城市出发必须经过每一个城市且只在一个城市逗留一次, 最后回到出发的城市,
 * 问如何事先确定一条最短的线路已保证其旅行的费用最少？
 */
public class Q020806TravelSalesmanProblem {

    public int minCost(int[][] p){
        int n = p.length;
        if (p == null || n == 0){
            return 0;
        }
        //i为某个城市
        //j为除去i城市的城市集合, 如 j = 0b1010 表示j集合中只有{2, 4}两个城市
        //d[i][j]表示从i出发 经历j集合中的所有城市 并回到起始城市(全局起始城市)的最小代价
        int[][] d = new int[n][1 << (n - 1)];
        for (int i = 1; i < d.length; i++) {
            d[i][0] = p[i][0];
        }
        for (int j = 1; j < d[0].length; j++) {
            for (int i = 0; i < d.length; i++) {
                d[i][j] = Integer.MAX_VALUE;
                if ((j >> (i - 1) & 1) == 1){ //j集合包含i城市
                    continue;
                }
                for (int k = 1; k < d[0].length; k++) {
                    if ((j >> (k - 1) & 1) == 1){ //j集合包含k城市
                        d[i][j] = Math.min(d[i][j], p[i][k] + d[k][j ^ (1 << (k - 1))]);
                    }
                }
            }
        }
        return d[0][d[0].length - 1];
    }

}
