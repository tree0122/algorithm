package com.tree.core.algorithm.leetcode;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
 *
 * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
 *
 * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
 *
 * 示例 1:
 *
 * 输入: [[0,2],[1,3]]
 * 输出: 3
 * 解释:
 * 时间为0时，你位于坐标方格的位置为 (0, 0)。
 * 此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
 *
 * 等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swim-in-rising-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P0778SwimInWater {

    public int swamInWater(int[][] grid){
        if (grid == null || grid.length == 0){
            return 0;
        }
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> grid[o[0]][o[1]]));
        heap.offer(new int[]{0, 0});
        int ans = grid[0][0];
        while (!heap.isEmpty()){
            int[] pos = heap.poll();
            if (ans < grid[pos[0]][pos[1]]){
                ans = grid[pos[0]][pos[1]];
            }
            visit[pos[0]][pos[1]] = true;
            if (pos[0] == grid.length - 1 && pos[1] == grid[0].length - 1){
                break;
            }
            if (pos[0] - 1 >= 0 && !visit[pos[0] - 1][pos[1]]){
                heap.offer(new int[]{pos[0] - 1, pos[1]});
            }
            if (pos[0] + 1 < grid.length && !visit[pos[0] + 1][pos[1]]){
                heap.offer(new int[]{pos[0] + 1, pos[1]});
            }
            if (pos[1] - 1 >= 0 && !visit[pos[0]][pos[1] - 1]){
                heap.offer(new int[]{pos[0], pos[1] - 1});
            }
            if (pos[1] + 1 < grid[0].length && !visit[pos[0]][pos[1] + 1]){
                heap.offer(new int[]{pos[0], pos[1] + 1});
            }
        }

        return ans;
    }

    @Test
    public void test(){
        int[][] a = {
                {0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}
        };
        System.out.println(swamInWater(a));
    }

}
