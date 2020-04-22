package com.tree.core.algorithm.leetcode;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 */
public class P0037SudokuSolver {

    public void solveSudoku(char[][] board) {
        process(board, 0, 0);
    }

    private boolean process(char[][] board, int i, int j) {
        if (i == board.length){
            return true;
        }
        if (j >= 9){
            return process(board, i + 1, 0);
        }
        if (board[i][j] != '.'){
            return process(board, i, j + 1);
        }
        for (int k = 0; k < 9; k++) {
            char ch = (char) (k + '1');
            if (!valid(board, i, j, ch)){
                continue;
            }
            board[i][j] = ch;
            if (process(board, i, j + 1)){
                return true;
            }
            board[i][j] = '.';
        }
        return false;
    }

    private boolean valid(char[][] board, int i, int j, char ch) {
        for (int k = 0; k < board.length; k++) {
            if (board[k][j] == ch){
                return false;
            }
        }
        for (int k = 0; k < board.length; k++) {
            if (board[i][k] == ch){
                return false;
            }
        }
        int row = i - i % 3, col = j - j % 3;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (board[row + x][col + y] == ch){
                    return false;
                }
            }
        }
        return true;
    }

}
