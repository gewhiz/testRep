/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.
*/

public class Solution {
    public void solveSudoku(char[][] board) {
        solve(0,0,board);
    }
    
     static boolean legal(int i, int j, int val, char[][] cells) {
        for (int k = 0; k < 9; ++k)  // row
            if (cells[k][j] != '.' && val == (cells[k][j]-'0'))
                return false;
                
        for (int k = 0; k < 9; ++k) // col
            if (cells[i][k] != '.' && val == (cells[i][k] - '0'))
                return false;
                
        int boxRowOffset = (i / 3)*3;
        int boxColOffset = (j / 3)*3;
        for (int k = 0; k < 3; ++k) // box
            for (int m = 0; m < 3; ++m){
                char temp = cells[boxRowOffset+k][boxColOffset+m];
                if (temp != '.' && val == temp - '0')
                    return false;
            }
            
        return true; // no violations, so it's legal
    }
    
    static boolean solve(int i, int j, char[][] cells) {
        if (i == 9) {
            i = 0;
            if (++j == 9)
                return true;
        }
        if (cells[i][j] != '.')  // skip filled cells
            return solve(i+1,j, cells);

        for (int val = 1; val <= 9; ++val) {
            if (legal(i,j,val, cells)) {
                cells[i][j] = Character.forDigit(val, 10);
                if (solve(i+1,j, cells))
                    return true;
            }
        }
        cells[i][j] = '.'; // reset on backtrack
        return false;
    }
}
