package com.tree.core.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class P0079WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0
                || word == null || word.length() == 0
                || word.length() > board.length * board[0].length){
            return false;
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (search(board, word, r, c, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] b, String w, int r, int c, int i) {
        if (i == w.length()){
            return true;
        }
        if (r < 0 || r >= b.length || c < 0 || c >= b[0].length){
            return false;
        }
        if (b[r][c] != w.charAt(i)){
            return false;
        }
        b[r][c] = '$';
        if (search(b, w, r - 1, c, i + 1)
                || search(b, w, r + 1, c, i + 1)
                || search(b, w, r , c - 1, i + 1)
                || search(b, w, r, c + 1, i + 1)
        ){
            return true;
        }else {
           b[r][c] = w.charAt(i);
           return false;
        }
    }

}
