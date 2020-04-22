package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */
public class P0036ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        List<Set<Character>> rowList = new ArrayList<>(len);
        List<Set<Character>> columnList = new ArrayList<>(len);
        List<Set<Character>> partList = new ArrayList<>(len);

        for (int i = 0; i < len; i++) {
            rowList.add(new HashSet<>(len));
            columnList.add(new HashSet<>(len));
            partList.add(new HashSet<>(len));
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                char ch = board[i][j];
                if (ch == '.'){
                    continue;
                }
                if (!rowList.get(i).add(ch)) {
                    return false;
                }
                if (!columnList.get(j).add(ch)){
                    return false;
                }
                if (!partList.get(3 * (i / 3) + j / 3).add(ch)){
                    return false;
                }
            }
        }
        return true;
    }

}
