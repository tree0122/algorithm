package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

import java.util.LinkedList;

/**
 * 给定一个字符串str,str表示一个公式,公式里可能有整数、加减乘除符号和
 * 左右括号,返回公式的计算结果。
 *
 * 【举例】
 * str="48*((70-65)-43)+8*1",返回-1816。
 * str="3+1*4",返回7。 str="3+(1*4)",返回7。
 *
 * 【说明】
 * 1.可以认为给定的字符串一定是正确的公式,即不需要对str做公式有效性检查。
 * 2.如果是负数,就需要用括号括起来,比如"4*(-3)"。但如果负数作为公式的
 * 开头或括号部分的开头,则可以没有括号,比如"-3*4"和"(-3*4)"都是合法的。
 * 3.不用考虑计算过程中会发生溢出的情况
 */
public class I0089Q020602ExpressionCompute {

    public int getValue(String s){
        if (s == null || s.length() == 0){
            return 0;
        }
        return value(s, 0)[1];
    }

    private int[] value(String s, int i){
        int pre = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        //处理一个小括号内的字符串逻辑,或者无括号的整个字符串逻辑
        while (i < s.length() && s.charAt(i) != ')'){
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){//找出整数
                pre = pre * 10 + (s.charAt(i++) - '0');
            }else if (s.charAt(i) != '('){//加减乘除运算
               pushNum(stack, pre);
               stack.push(s.charAt(i++) * 1);
               pre = 0;
            }else {//潜台词，遇到有括号（
                int[] v = value(s, i + 1);
                pre = v[0];
                i = v[1] + 1;
            }
        }
        pushNum(stack, pre);
        return new int[]{compute(stack), i};
    }

    /**
     * 将刚得到的整数num放入stack中, 如果stack的peek是乘除, 则进行乘除运算后放入, 否则直接放入
     *
     * @param stack 包含整数的栈
     * @param num 刚得到的整数
     */
    private void pushNum(LinkedList<Integer> stack, int num) {
        if (stack.isEmpty()){
            stack.push(num);
            return;
        }
        Integer op = stack.pop();
        if (op == '+' || op == '-'){
            stack.push(op);
            stack.push(num);
        }else {
            Integer pop = stack.pop();
            stack.push(op == '*' ? num * pop : pop / num);
        }
    }

    /**
     * 计算stack内的所有值
     *
     * @param stack stack中包含整数和加减符号
     * @return 表达式结果
     */
    private int compute(LinkedList<Integer> stack) {
        int ans = 0;
        int op = 1;
        while (!stack.isEmpty()){
            Integer cur = stack.pollFirst();
            if (cur == '+'){
                op = 1;
            }else if (cur == '-'){
                op = -1;
            }else {
                ans += op * cur;
            }
        }
        return ans;
    }

}
