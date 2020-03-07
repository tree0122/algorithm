package com.tree.core.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 输入一个按升序排序的整数数组（可能包含重复数字），你需要将它们分割成几个子序列，其中每个子序列至少包含三个连续整数。返回你是否能做出这样的分割？
 *
 *  
 *
 * 示例 1：
 *
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路:
 * 问题分析
 *
 * countMap 保存数组元素对应个数
 * taiMap 用来判断当前元素是否能够插入到一个已经构建好的序列末端
 * 遍历nums，判断一个元素是否能够插入一个已经构建好的序列的末端，或者是否能作为新序列的起点，如果两者都不可以，返回false。
 */
public class P0659SplitArray {

    public boolean isPossible(int[] nums){
        if (nums == null || nums.length < 3){
            return false;
        }
        /** key数组元素, value此元素对应的个数 */
        HashMap<Integer, Integer> countMap = new HashMap<>();
        /** key当前元素, value是 以key为结尾的序列个数 */
        HashMap<Integer, Integer> tailMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            // 当前元素的个数为0, 跳过比较下个元素
            if (countMap.get(num) == 0){
                continue;
            }
            // 优先加入已有序列
            // 若以 当前元素的前一个元素 为结尾的序列个数 大于0, 则将当前元素追加到此序列
            if (tailMap.getOrDefault(num - 1, 0) > 0){
                tailMap.put(num - 1, tailMap.get(num - 1) - 1);
                tailMap.put(num, tailMap.getOrDefault(num, 0) + 1);
            }else if (countMap.getOrDefault(num + 1, 0) > 0 && countMap.getOrDefault(num + 2, 0) > 0){
                // 构建一个新序列
                countMap.put(num + 1, countMap.get(num + 1) - 1);
                countMap.put(num + 2, countMap.get(num + 2) - 1);
                tailMap.put(num + 2, tailMap.getOrDefault(num + 2, 0) + 1);
            }else {
                // 当前元素个数不为0, 且不能添加到已有序列, 不能组成一个新序列, 直接return false
                return false;
            }
            countMap.put(num, countMap.get(num) - 1);
        }
        return true;
    }

}
