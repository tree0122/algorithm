package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入:
 * 参数1, 正数数组costs
 * 参数2, 正数数组profits
 * 参数3, 正数k
 * 参数4, 正数m
 * costs[i]表示i号项目的花费,
 * profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
 * k表示你不能并行、只能串行的最多做k个项目
 * m表示你初始的资金
 * 说明:你每做完一个项目,马上获得的收益,可以支持你去做下
 * 一个 项目.
 * 输出: 你最后获得的最大钱数
 */
public class I0048Q010803IPO {

    public int maxCapital(int[] cost, int[] profit, int capital, int k){
        if (cost == null || cost.length == 0
                || profit == null || profit.length == 0
                || cost.length != profit.length || capital <= 0 || k <= 0){
            return capital;
        }
        PriorityQueue<Program> cannot = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));
        PriorityQueue<Program> can = new PriorityQueue<>((p1, p2) -> p2.profit - p1.profit);
        for (int i = 0; i < cost.length; i++) {
            Program program = new Program(cost[i], profit[i]);
            if (program.cost <= capital){
                can.offer(program);
            }else {
                cannot.offer(program);
            }
        }
        int i = 0;
        while (i < k && !can.isEmpty()){
            Program p = can.poll();
            capital += p.profit;
            while (cannot.peek().cost <= capital){
                can.offer(cannot.poll());
            }
        }
        return capital;
    }

    private class Program{
        int cost;
        int profit;
        public Program(int cost, int profit){
            this.cost = cost;
            this.profit = profit;
        }
    }

}
