package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 */
public class P0119PascalTriangle2 {

    public List<Integer> getRow(int rowIndex){
        if (rowIndex < 0){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            ans.add(0);
        }
        ans.set(0, 1);
        for (int i = 1; i <= rowIndex; i++) {
            ans.set(i, 1);
            for (int j = i - 1; j > 0; j--) {
                ans.set(j, ans.get(j) + ans.get(j - 1));
            }
        }
        return ans;
    }

}
