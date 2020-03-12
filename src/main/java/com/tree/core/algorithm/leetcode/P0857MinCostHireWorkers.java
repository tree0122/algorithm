package com.tree.core.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 有 N 名工人。 第 i 名工人的工作质量为 quality[i] ，其最低期望工资为 wage[i] 。
 *
 * 现在我们想雇佣 K 名工人组成一个工资组。在雇佣 一组 K 名工人时，我们必须按照下述规则向他们支付工资：
 *
 * 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
 * 工资组中的每名工人至少应当得到他们的最低期望工资。
 * 返回组成一个满足上述条件的工资组至少需要多少钱。
 *
 *  
 *
 * 示例 1：
 *
 * 输入： quality = [10,20,5], wage = [70,50,30], K = 2
 * 输出： 105.00000
 * 解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-cost-to-hire-k-workers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P0857MinCostHireWorkers {

    public double minCost(int[] quality, int[] wage, int K){
        if (quality == null || wage == null || K < 1 || quality.length == 0 || quality.length != wage.length){
            return 0;
        }
        // rateHeap 按员工的性价比
        PriorityQueue<Integer> rateHeap = new PriorityQueue<>(Comparator.comparingDouble(i -> (double) wage[i] / quality[i]));
        // qualityHeap 员工的工作质量 逆序
        PriorityQueue<Integer> qualityHeap = new PriorityQueue<>((i1, i2) -> quality[i2] - quality[i1]);
        for (int i = 0; i < quality.length; i++) {
            rateHeap.offer(i);
        }
        int sumQuality = 0;
        int j = 0;
        for (int i = 0; i < K; i++) {
            j = rateHeap.poll();
            qualityHeap.offer(j);
            sumQuality += quality[j];
        }
        double ans = (double) wage[j] / quality[j] * sumQuality;
        while (!rateHeap.isEmpty()){
            int p = rateHeap.poll();
            if (quality[p] < quality[qualityHeap.peek()]){
                sumQuality = sumQuality - quality[qualityHeap.poll()] + quality[p];
                qualityHeap.offer(p);
                ans = Math.min(ans, (double) wage[p] / quality[p] * sumQuality);
            }

        }
        return ans;
    }

}
