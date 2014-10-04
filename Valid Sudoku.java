//Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

//The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


//A partially filled sudoku which is valid.

//Note:
//A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++)
        {
            boolean[] hmap = new boolean[10];
            boolean[] vmap = new boolean[10];
            for(int j = 0; j<9; j++)
            {
                char num = board[i][j];
                if(num != '.')
                {
                    int n = Character.getNumericValue(num);
                    if(hmap[n])
                        return false;
                    hmap[n] = true;
                }
                char num2= board[j][i];
                if(num2 != '.')
                {
                    int n = Character.getNumericValue(num2);
                    if(vmap[n])
                        return false;
                    vmap[n] = true;
                }
            }
        }
        for(int i = 0; i<9; i++)
        {
            boolean[] map = new boolean[10];
            int h = i/3;
            int v = i%3;
            for(int j = 0; j< 3; j++)
            {
                for(int k = 0; k<3; k++)
                {
                    char num = board[h*3+j][v*3+k];
                    if(num != '.'){
                        int n = Character.getNumericValue(num);
                    if(map[n])
                        return false;
                    map[n] = true;
                    }
                }
            }
        }
        return true;
        
    }
}
