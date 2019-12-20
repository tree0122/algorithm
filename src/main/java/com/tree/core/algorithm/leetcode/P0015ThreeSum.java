package com.tree.core.algorithm.leetcode;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class P0015ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        HashMap<Integer, Set<String>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] + nums[j];
                if (map.containsKey(key)) {
                    map.get(key).add(i + "," + j);
                }else {
                    HashSet<String> set = new HashSet<>();
                    set.add(i + "," + j);
                    map.put(key, set);
                }
            }
        }
        HashSet<String> ansSet = new HashSet<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Set<String> set = map.get(0 - nums[i]);
            if (set != null){
                for (String s : set) {
                    if (s.contains(String.valueOf(i))){
                        continue;
                    }
                    String[] ss = s.split(",");
                    int[] a = {nums[i], nums[Integer.parseInt(ss[0])], nums[Integer.parseInt(ss[1])]};
                    Arrays.sort(a);
                    ansSet.add(a[0] + "," + a[1] + "," + a[2]);
                }
            }
        }
        for (String s : ansSet) {
            ArrayList<Integer> list = new ArrayList<>();
            for (String r : s.split(",")) {
                list.add(Integer.parseInt(r));
            }
            ans.add(list);
        }
        return ans;
    }

    public List<List<Integer>> ss(int[] nums) {
        if (nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0){
                        int[] a = {nums[i], nums[j], nums[k]};
                        Arrays.sort(a);
                        set.add(a[0] + "," + a[1] + "," + a[2]);
                    }
                }
            }
        }

        for (String s : set) {
            ArrayList<Integer> list = new ArrayList<>();
            for (String i : s.split(",")) {
                list.add(Integer.parseInt(i));
            }
            ans.add(list);
        }
        return ans;
    }

    public List<List<Integer>> better(int[] nums){
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0){
                break;
            }
            if (i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int target = 0 - nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                if (nums[j] + nums[k] == target){
                    //add
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    while (j < k && nums[j] == nums[j + 1]){
                        j++;
                    }
                    while (j < k & nums[k] == nums[k - 1]){
                        k--;
                    }
                    i++;
                    k--;
                }else if (nums[j] + nums[k] < target){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return ans;
    }

}
