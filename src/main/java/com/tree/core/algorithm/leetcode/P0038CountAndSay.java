package com.tree.core.algorithm.leetcode;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * You can do so recursively, in other words from the previous member read off the digits,
 * counting the number of digits in groups of the same digit.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 */
public class P0038CountAndSay {

    public String countAndSay(int n){
        if (n == 1){
            return "1";
        }
        String last = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char pre = last.charAt(0);
        for (int i = 1; i < last.length(); i++) {
            if (pre == last.charAt(i)){
                count++;
            }else {
                sb.append(count).append(pre);
                count = 1;
                pre = last.charAt(i);
            }
        }
        sb.append(count).append(pre);
        return sb.toString();
    }

}
