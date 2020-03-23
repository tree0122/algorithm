package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class P0118PascalTriangle {

    public List<List<Integer>> generate(int numRows){
        if (numRows <= 0){
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> ans = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> curList = new ArrayList<>(i + 1);
            curList.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> last = ans.get(i - 1);
                curList.add(last.get(j - 1) + last.get(j));
            }
            if (i > 0){
                curList.add(1);
            }
            ans.add(curList);
        }
        return ans;
    }

}
