/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
	        int len2 = s2.length();
	        int len3 = s3.length();
	        if(len1 == 0 || len2 == 0)
	        {
	            if(s3.equals(s1) || s3.equals(s2))
	                return true;
	            return false;
	        }
	        if(len3 != len1 + len2)
	            return false;
	        
	        boolean[][] mat = new boolean[len1+1][len2+1];
	        for(int i = 1; i<=len1; i++)
	        {
	        	if(s1.charAt(i-1) == s3.charAt(i-1))
	                mat[i][0] = true;
	        }
	        for(int i = 1; i<=len2; i++)
	        {
	        	if(s2.charAt(i-1) == s3.charAt(i-1))
	                mat[0][i] = true;
	        }
	        for(int i = 1; i<=len1; i++)
	        {
	            for(int j =1; j<=len2; j++)
	            {	                    
	                char look = s3.charAt(i+j-1);
	                char cur1 = s1.charAt(i-1);
	                char cur2 = s2.charAt(j-1);
	                if(look == cur1 && mat[i-1][j])
	                    mat[i][j] = true;
	                if(look == cur2 && mat[i][j-1])
	                    mat[i][j] = true;
	            }
	        }
	        return mat[len1][len2];
    }
}
