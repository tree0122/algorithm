package com.tree.core.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个 m x n 的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 *
 *  
 *
 * 说明:
 *
 * m 和 n 都是小于110的整数。每一个单位的高度都大于 0 且小于 20000。
 *
 *  
 *
 * 示例：
 *
 * 给出如下 3x6 的高度图:
 * [
 *   [1,4,3,1,3,2],
 *   [3,2,1,3,2,4],
 *   [2,3,3,2,3,1]
 * ]
 *
 * 返回 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P0407TrapRainWaterII {

    public int trapRainWater(int[][] heightMap){
        if (heightMap == null || heightMap.length == 0){
            return 0;
        }
        int ans = 0;
        int waterLevel = 0;
        int[] cur = null;
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        int[][] visit = new int[rows][cols];
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n[2]));
        for (int i = 0; i < cols; i++) {
            heap.offer(new int[]{0, i, heightMap[0][i]});
            visit[0][i] = 1;
            heap.offer(new int[]{rows - 1, i, heightMap[rows - 1][i]});
            visit[rows - 1][i] = 1;
        }
        for (int i = 1; i < rows - 1; i++) {
            heap.offer(new int[]{i, 0, heightMap[i][0]});
            visit[i][0] = 1;
            heap.offer(new int[]{i, cols - 1, heightMap[i][cols - 1]});
            visit[i][cols - 1] = 1;
        }
        while (!heap.isEmpty()){
            cur = heap.poll();
            if (waterLevel < cur[2]){
                waterLevel = cur[2];
            }
            if (cur[0] - 1 >= 0 && visit[cur[0] - 1][cur[1]] != 1){
                if (waterLevel > heightMap[cur[0] - 1][cur[1]]){
                    ans += (waterLevel - heightMap[cur[0] - 1][cur[1]]);
                }
                visit[cur[0] - 1][cur[1]] = 1;
                heap.offer(new int[]{cur[0] - 1, cur[1], heightMap[cur[0] - 1][cur[1]]});
            }
            if (cur[0] + 1 < rows && visit[cur[0] + 1][cur[1]] != 1){
                if (waterLevel > heightMap[cur[0] + 1][cur[1]]){
                    ans += (waterLevel - heightMap[cur[0] + 1][cur[1]]);
                }
                visit[cur[0] + 1][cur[1]] = 1;
                heap.offer(new int[]{cur[0] + 1, cur[1], heightMap[cur[0] + 1][cur[1]]});
            }
            if (cur[1] - 1 >= 0 && visit[cur[0]][cur[1] - 1] != 1){
                if (waterLevel > heightMap[cur[0]][cur[1] - 1]){
                    ans += (waterLevel - heightMap[cur[0]][cur[1] - 1]);
                }
                visit[cur[0]][cur[1] - 1] = 1;
                heap.offer(new int[]{cur[0], cur[1] - 1, heightMap[cur[0]][cur[1] - 1]});
            }
            if (cur[1] + 1 < cols && visit[cur[0]][cur[1] + 1] != 1){
                if (waterLevel > heightMap[cur[0]][cur[1] + 1]){
                    ans += (waterLevel - heightMap[cur[0]][cur[1] + 1]);
                }
                visit[cur[0]][cur[1] + 1] = 1;
                heap.offer(new int[]{cur[0], cur[1] + 1, heightMap[cur[0]][cur[1] + 1]});
            }
        }
        return ans;
    }

}
