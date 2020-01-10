package com.tree.core.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target,
 * are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class P0018FourSum {

    public List<List<Integer>> fourSum(int[] a, int target) {
        if (a == null || a.length < 4){
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> list = new ArrayList<>();
        Arrays.sort(a);
        for (int i = 0; i < a.length - 3; i++) {
            if (i != 0 && a[i] == a[i - 1]){
                continue;
            }
            for (int j = i + 1; j < a.length - 2; j++) {
                if (j != i + 1 && a[j] == a[j - 1]){
                    continue;
                }
                for (int m = j + 1, n = a.length - 1; m < n;) {
                    int sum = a[i] + a[j] + a[m] + a[n];
                    if (sum == target){
                        list.add(Arrays.asList(a[i], a[j], a[m], a[n]));
                        while (m < n && a[m] == a[m + 1]){
                            m++;
                        }
                        while (m < n && a[n] == a[n - 1]){
                            n--;
                        }
                        m++;
                        n--;
                    }else if (sum < target){
                        m++;
                    }else {
                        n--;
                    }
                }
            }

        }
        return list;
    }

    @Test
    public void test(){
        int[] a = {-2, -1, 0, 0, 1, 2};
        System.out.println(fourSum(a, 0));
    }
    /*
    public List<List<Integer>> fourSum(int[] a, int target) {
        if (a == null || a.length < 4){
            return new ArrayList<>();
        }
        Arrays.sort(a);
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i = 0, j = a.length - 1; i <= j - 3;) {
            while (i != 0 && i != j - 3 && a[i] == a[i - 1]){
                i++;
                continue;
            }
            while (j != i && j - 3 != a.length - 1 && a[j] == a[j + 1]){
                j--;
                continue;
            }
            for (int m = i + 1, n = j - 1; m < n;) {
                int sum = a[i] + a[j] + a[m] + a[n];
                if (sum < target){
                    m++;
                }else if (sum > target){
                    n--;
                }else {
                    list.add(Arrays.asList(a[i], a[m], a[n], a[j]));
                    while (a[m] == a[m + 1] && m < n){
                        m++;
                    }
                    while (a[n] == a[n - 1] && n > m){
                        n--;
                    }
                    m++;
                    n--;
                }
            }
            i++;
            j--;
        }
        return list;
    }
*/

}
