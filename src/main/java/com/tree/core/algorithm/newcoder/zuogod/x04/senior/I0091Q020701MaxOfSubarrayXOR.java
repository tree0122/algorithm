package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * 课件代码: Max_EOR
 * 给定一个数组,求子数组的最大异或和。
 * 一个数组的异或和为,数组中所有的数异或起来的结果
 */
public class I0091Q020701MaxOfSubarrayXOR {

     public int maxEorSubarray(int[] a){
        if (a == null || a.length == 0){
            return 0;
        }

        int ans = Integer.MIN_VALUE;
        NumTrie numTrie = new NumTrie();
        numTrie.add(0);
        int eor = 0;
        for (int i = 0; i < a.length; i++) {
            eor ^= a[i];
            ans = Math.max(ans, numTrie.maxEor(eor));
            numTrie.add(eor);
        }
        return ans;
    }

    private class NumTrie{
        private Node head = new Node();

        public void add(int num){
            Node cur = head;
            for (int move = 31; move >= 0; move--) {
                int bit = (num >> move) & 1;
                cur.nexts[bit] = cur.nexts[bit] == null ? new Node() : cur.nexts[bit];
                cur = cur.nexts[bit];
            }
        }

        public int maxEor(int num){
            int ans = 0;
            Node cur = head;
            for (int move = 31; move >= 0; move--) {
                int bit = (num >> move) & 1; //num二进制表达，在move位的值
                int best = move == 31 ? bit : (bit ^ 1); //numTrie中，期待在move位的值
                best = cur.nexts[best] != null ? best : bit; //numTrie中，实际在move的值
                ans |= (bit ^ best) << move; //结果在move的值
                cur = cur.nexts[best]; //继续
            }
            return ans;
        }
    }

    private class Node{
        Node[] nexts = new Node[2];
    }

    private int right(int[] a){
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int xor = 0;
            for (int j = i; j >= 0; j--) {
                xor ^= a[j];
            }
            res = Math.max(res, xor);
        }
        return res;
    }

}
