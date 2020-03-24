package com.tree.core.algorithm.leetcode;

import org.junit.Test;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 */
public class P0168ExcelSheetColumnTitle {

    public String convertToTitle(int n){
        if (n <= 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            sb.append((char) (--n % 26 + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    public String awesome(int n){
        return n <= 0 ? "" : awesome(n / 26) + (char) (--n % 26 + 'A');
    }

    @Test
    public void test(){
        System.out.println(awesome(28));
    }

}
