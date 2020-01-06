package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个公司的上下节关系是一棵多叉树,这个公司要举办晚会,你作为组织者已经摸清了大家的心理:一个员工的直
 * 接上级如果到场,这个员工肯定不会来。每个员工都有一个活跃度的值,决定谁来你会给这个员工发邀请函,怎么
 * 让舞会的气氛最活跃?返回最大的活跃值。
 *
 * 举例:
 * 给定一个矩阵来表述这种关系
 * matrix = {
 *  1,  6
 *  1,  5
 *  1,  4
 * }
 *
 * 这个矩阵的含义是:
 * matrix[0] = {1 , 6},表示0这个员工的直接上级为1,0这个员工自己的活跃度为6
 * matrix[1] = {1 , 5},表示1这个员工的直接上级为1(他自己是这个公司的最大boss),1这个员工自己的活跃度为5
 * matrix[2] = {1 , 4},表示2这个员工的直接上级为1,2这个员工自己的活跃度为4
 * 为了让晚会活跃度最大,应该让1不来,0和2来。最后返回活跃度为10
 */
public class Q020503MaxHappy {

    public int maxDistance(Employee boss){
        int[] ret = process(boss);
        return Math.max(ret[0], ret[1]);
    }

    /**
     * 每个节点的情况
     *
     * @param employee
     * @return a[0]当前员工来的活跃度, a[1]当前员工不来的活跃度
     */
    public int[] process(Employee employee){
        int[] a = new int[2];
        a[0] = employee.happy;
        for (Employee e : employee.employees) {
            int[] d = process(e);
            a[0] += d[1];
            a[1] += Math.max(d[0], d[1]);
        }
        return a;
    }

    private class Employee {
        int happy;
        List<Employee> employees = new ArrayList<>();
    }

}
