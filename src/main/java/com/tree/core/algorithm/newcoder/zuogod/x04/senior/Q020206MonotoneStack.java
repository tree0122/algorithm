package com.tree.core.algorithm.newcoder.zuogod.x04.senior;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 单调栈概念
 * 作用: 数组中, 任意一个元素a[i], 其左边和右边最近且大于它的元素
 * 结构: 单调栈(栈底->栈顶, 大->小)
 */
public class Q020206MonotoneStack {

    /**
     * 找出数组a的每个元素, 比其大的的左右最近的元素
     *
     * @param a 数组
     * @return map
     */
    public Map<Integer, Integer[]> getLeftRightNearestBig(int[] a){
        if (a == null || a.length == 0){
            return null;
        }
        HashMap<Integer, Integer[]> map = new HashMap<>();
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && a[stack.peekLast()] < a[i]){
                int pos = stack.pollLast();
                Integer left = stack.isEmpty() ? null : stack.peekLast();
                map.put(pos, new Integer[]{left, i});
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int pos = stack.pollLast();
            Integer left = stack.isEmpty() ? null : stack.peekLast();
            map.put(pos, new Integer[]{left, null});
        }
        return map;
    }

    public Map<Integer, Integer[]> getLeftRightNearestBigWithEqual(int[] a){
        if (a == null || a.length == 0){
            return null;
        }
        HashMap<Integer, Integer[]> map = new HashMap<>();
        LinkedList<LinkedList<Integer>> stack = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && a[stack.peekLast().peekLast()] < a[i]){
                LinkedList<Integer> pos = stack.pollLast();
                Integer left = stack.isEmpty() ? null : stack.peekLast().peekLast();
                for (Integer po : pos) {
                    map.put(po, new Integer[]{left, i});
                }
            }
            LinkedList<Integer> last = stack.pollLast();
            if (last == null){
                last = new LinkedList<>();
            }
            last.push(i);
            stack.push(last);
        }
        while (!stack.isEmpty()){
            LinkedList<Integer> pos = stack.pollLast();
            Integer left = stack.isEmpty() ? null : stack.peekLast().peekLast();
            for (Integer po : pos) {
                map.put(po, new Integer[]{left, null});
            }
        }
        return map;
    }



}
