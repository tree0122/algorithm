package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 排成一条线的纸牌博弈问题
 *
 * 【题目】
 * 给定一个整型数组arr,代表数值不同的纸牌排成一条线。玩家A和玩家B依次拿走
 * 每张纸牌,规定玩家A先拿,玩家B后拿,但是每个玩家每次只能拿走最左或最右
 * 的纸牌,玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。
 *
 * 【举例】
 * arr=[1,2,100,4]。
 * 开始时玩家A只能拿走1或4。如果玩家A拿走1,则排列变为[2,100,4],接下来玩
 * 家B可以拿走2或4,然后继续轮到玩家A。如果开始时玩家A拿走4,则排列变为
 * [1,2,100],接下来玩家B可以拿走1或100,然后继续轮到玩家A。玩家A作为绝顶
 * 聪明的人不会先拿4,因为拿4之后,玩家B将拿走100。所以玩家A会先拿1,让排
 * 列变为[2,100,4],接下来玩家B不管怎么选,100都会被玩家A拿走。玩家A会获胜,
 * 分数为101。所以返回101。
 * arr=[1,100,2]。
 * 开始时玩家A不管拿1还是2,玩家B作为绝顶聪明的人,都会把100拿走。玩家B会
 * 获胜,分数为100。所以返回100
 */
public class Q010902CardsInLine {

    public int best(int[] a){
        if (a == null || a.length == 0){
            return 0;
        }
        if (a.length == 1){
            return a[0];
        }
        int[] d1 = new int[a.length];
        int[] d2 = new int[a.length];
        d1[d1.length - 1] = a[a.length - 1];
        for (int i = d1.length - 2; i >= 0; i--) {
            d1[i] = a[i];
            for (int j = i + 1; j < d1.length; j++) {
                d1[j] = Math.max(a[i] + d2[i + 1], a[j] + d2[j - 1]);
                d2[j] = Math.min(d1[i + 1], d1[j - 1]);
            }
        }
        return Math.max(d1[a.length - 1], d2[a.length - 1]);
    }

    public int win(int[] a){
        if (a == null || a.length == 0){
            return 0;
        }
        if (a.length == 1){
            return a[0];
        }
        return Math.max(first(a, 0, a.length - 1), second(a, 0, a.length - 1));
    }

    private int first(int[] a, int i, int j) {
        if (i == j){
            return a[i];
        }
        return Math.max(
                a[i] + second(a, i + 1, j),
                a[j] + second(a, i, j - 1)
        );
    }

    private int second(int[] a, int i, int j) {
        if (i == j){
            return 0;
        }
        return Math.min(
                first(a, i + 1, j),
                first(a, i, j - 1)
        );
    }

}
