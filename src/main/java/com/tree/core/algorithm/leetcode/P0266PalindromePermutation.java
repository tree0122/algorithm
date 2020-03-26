package com.tree.core.algorithm.leetcode;

import java.util.HashSet;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * Example 1:
 *
 * Input: "code"
 * Output: false
 * Example 2:
 *
 * Input: "aab"
 * Output: true
 * Example 3:
 *
 * Input: "carerac"
 * Output: true
 * Hint:
 *
 * Consider the palindromes of odd vs even length. What difference do you notice?
 * Count the frequency of each character.
 * If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
 */
public class P0266PalindromePermutation {

    public boolean canPermutePalindrome(String s){
        HashSet<Character> set = new HashSet<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
            }else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }

}
