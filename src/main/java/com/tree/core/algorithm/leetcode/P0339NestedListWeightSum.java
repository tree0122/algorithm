package com.tree.core.algorithm.leetcode;

import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 *
 * Input: [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: Four 1's at depth 2, one 2 at depth 1.
 * Example 2:
 *
 * Input: [1,[4,[6]]]
 * Output: 27
 * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 */
public class P0339NestedListWeightSum {

    public int depthSumInverse(List<NestedInteger> nestedList){
        return process(nestedList, 1);
    }

    private int process(List<NestedInteger> nestedList, int level) {
        int res = 0;
        for (NestedInteger ni : nestedList) {
            res += ni.isInteger() ? ni.getInteger() * level : process(ni.getList(), level + 1);
        }
        return res;
    }

    private interface NestedInteger{
        boolean isInteger();

        Integer getInteger();

        void setInteger(int val);

        void add(NestedInteger ni);

        List<NestedInteger> getList();
    }

}
