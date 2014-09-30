//Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

//You have the following 3 operations permitted on a word:

//a) Insert a character
//b) Delete a character
//c) Replace a character

public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == "")
            return word2.length();
        if(word2 == "")
            return word1.length();
        int m = word1.length();
        int n = word2.length();
        
        int[][] map = new int[m+1][n+1];
        for(int i = 0; i<m+1; i++)
        {
            map[i][0] = i;
        }
        for(int i = 0; i<n+1; i++)
        {
            map[0][i] = i;
        }
        boolean flag = false;
        for(int i = 1; i<m+1; i++)
        {
            for(int j = 1;j<n+1;j++)
            {
                int left = map[i][j-1] + 1;
	                int up = map[i-1][j] +1;
	                int diag = map[i-1][j-1];
	                if(word1.charAt(i-1) != word2.charAt(j-1))
	                {
	                    diag = diag+1;
	                }
	                
	                int min = left;
	                if(up<left)
	                    min = up;
	                if(diag < min){
	                    min = diag;
	                }
	                
	                map[i][j] = min;
            }
        }

        return map[m][n];

    }
}
