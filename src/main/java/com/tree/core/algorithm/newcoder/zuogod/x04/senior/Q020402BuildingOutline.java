package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

import java.util.*;

/**
 * 给定一个N行3列二维数组,每一行表示有一座大楼,一共有N座
 * 大楼。 所有大楼的底部都坐落在X轴上,每一行的三个值
 * (a,b,c)代表每座大楼的从(a,0)点开始,到 (b,0)点结束,高
 * 度为c。 输入的数据可以保证a<b,且a,b,c均为正数。大楼之
 * 间可以有重合。 请输出整体的轮廓线。
 *
 * 例子:给定一个二维数组 [ [1, 3, 3], [2, 4, 4], [5, 6, 1] ]
 * 输出为轮廓线 [ [1, 2, 3], [2, 4, 4], [5, 6, 1] ]
 */
public class Q020402BuildingOutline {

    public List<List<Integer>> outline(int[][] building){
        if (building == null || building.length == 0){
            return null;
        }
        PriorityQueue<Node> nodes = new PriorityQueue<>(
                building.length * 2,
                (n1, n2) -> n1.pos != n2.pos ? n1.pos - n2.pos : n1.isUp ? 1 : -1
        );
        for (int i = 0; i < building.length; i++) {
            nodes.offer(new Node(building[i][0], building[i][2], true));
            nodes.offer(new Node(building[i][1], building[i][2], false));
        }
        TreeMap<Integer, Integer> nMap = new TreeMap<>();
        TreeMap<Integer, Integer> hMap = new TreeMap<>();
        while (!nodes.isEmpty()){
            Node n = nodes.poll();
            if (n.isUp){
                hMap.put(n.h, hMap.getOrDefault(n.h, 0) + 1);
            }else {
                Integer val = hMap.get(n.h);
                if (val == 1){
                    hMap.remove(n.h);
                }else {
                    hMap.put(n.h, val - 1);
                }
            }
            nMap.put(n.pos, hMap.isEmpty() ? 0 : hMap.lastKey());
        }
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int begin = 0;
        int height = 0;
        for (Map.Entry<Integer, Integer> entry : nMap.entrySet()) {
            Integer curPos = entry.getKey();
            Integer curHeight = entry.getValue();
            if (curHeight != height){
                if (height != 0){
                    ArrayList<Integer> line = new ArrayList<>(3);
                    line.add(begin);
                    line.add(curPos);
                    line.add(height);
                    ans.add(line);
                }
                begin = curPos;
                height = curHeight;
            }
        }
        return ans;
    }

    private class Node{
        int pos;
        int h;
        boolean isUp;
        public Node(int pos, int h, boolean isUp){
            this.pos = pos;
            this.h = h;
            this.isUp = isUp;
        }
    }



}
