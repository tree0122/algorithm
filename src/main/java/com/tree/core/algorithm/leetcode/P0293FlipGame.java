package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip twoconsecutive "++" into "--". The game ends when a person
 * can no longer make a move and therefore the other person will be the winner.
 *
 * Write a function to compute all possible states of the string after one valid move.
 *
 * For example, given s = "++++", after one move, it may become one of the following states:
 *
 * [
 *   "--++",
 *   "+--+",
 *   "++--"
 * ]
 *
 *
 * If there is no valid move, return an empty list [].
 */
public class P0293FlipGame {

    public List<String> generatePossibleNextMoves(String s){
        List<String> list = new ArrayList<>();
        if (s == null || s.length() <= 1){
            return list;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+'){
                list.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
            }
        }
        return list;
    }

}
