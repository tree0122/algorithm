package com.tree.core.algorithm.newcoder.zuogod.x04.senior;


/**
 * 无序数组中, topK的 O(N)实现
 * 1. 常见的方式是 堆实现, 但时间复杂度O(N*lgK)
 * 2. 快排的partition可以达到长期期望的O(N)
 * 3. bfprt可以达到严格的O(N)
 *
 *
 * https://zhuanlan.zhihu.com/p/31498036(比较详情)
 *
 * 在BFPTR算法中, 仅仅是改变了快速排序Partion中的pivot值的选取,
 * 在快速排序中, 我们始终选择第一个元素或者最后一个元素作为pivot,
 * 而在BFPTR算法中, 每次选择五分中位数的中位数作为pivot,
 * 这样做的目的就是使得划分比较合理, 从而避免了最坏情况的发生。
 * 算法步骤如下:
 * 1. 将 n 个元素划为 [n/5] 组, 每组5个, 至多只有一组由 n/5 个元素组成。
 * 2. 寻找这 [n/5] 个组中每一个组的中位数, 这个过程可以用插入排序。
 * 3. 对步骤2中的 [n/5] 个中位数, 重复步骤1和步骤2, 递归下去, 直到剩下一个数字。
 * 4. 最终剩下的数字即为pivot, 把大于它的数全放左边, 小于等于它的数全放右边。
 * 5. 判断pivot的位置与k的大小, 有选择的对左边或右边递归
 */
public class Q020202BFPRT {

    public int[] kMin(int[] a, int k){
        if (a == null || a.length <= k){
            return a;
        }
        int[] ans = new int[k];
        int kth = kthByBfprt(a, 0, a.length - 1, k);
        int j = 0;
        for (int i = 0; i < a.length && j < k; i++) {
            if (a[i] < kth){
                ans[j++] = a[i];
            }
        }
        while (j < k){
            ans[j++] = kth;
        }
        return ans;
    }

    private int kthByBfprt(int[] a, int i, int j, int k) {
        int pivot = medianOfMedian(a, i, j);
        int[] e = partition(a, i, j, pivot);
        if (k < e[0]){
            return kthByBfprt(a, i, e[0] - 1, k);
        }else if (k > e[1]){
            return kthByBfprt(a, e[1] + 1, j, k);
        }else {
            return a[k];
        }
    }

    private int[] partition(int[] a, int i, int j, int pivot) {
        int less = i - 1;
        int more = j + 1;
        while (i < more){
            if (a[i] < pivot){
                swap(a, i++, ++less);
            }else if (a[i] > pivot){
                swap(a, i, --more);
            }else {
                i++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    private int medianOfMedian(int[] a, int i, int j) {
        int len = (j - i + 1) / 5;
        if ((j - i + 1) % 5 != 0){
            len++;
        }
        int[] t = new int[len];
        for (int m = 0; m < t.length; m++) {
            int b = i + m * 5;
            int e = Math.min(b + 4, j);
            t[m] = medianByInsert(a, b, e);
        }
        return kthByBfprt(t, 0, t.length - 1, t.length / 2);
    }

    private int medianByInsert(int[] a, int b, int e) {
        for (int i = b + 1; i <= e; i++) {
            for (int j = i; j > b && a[j] < a[j - 1]; j--) {
                swap(a, j, j - 1);
            }
        }
        return a[(b + e) / 2];
    }

    private void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

}
