package com.tree.core.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class P0017LetterCombinationsOfOnePhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        String[] a = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String[] t = new String[digits.length()];
        for(int i = 0; i < digits.length(); i++){
            t[i] = a[digits.charAt(i) - '0' - 2];
        }
        List<String> list = new ArrayList<>();
        char[] cs = new char[digits.length()];
        process(t, 0, cs, list);
        return list;
    }

    private void process(String[] t, int i, char[] cs, List<String> list) {
        if (i == cs.length){
            list.add(String.valueOf(cs));
            return;
        }
        for (int j = 0; j < t[i].length(); j++) {
            cs[i] = t[i].charAt(j);
            process(t, i + 1, cs, list);
        }
    }

    @Test
    public void test(){
        System.out.println(letterCombinations("23"));
    }


}
