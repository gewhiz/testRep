/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        if(len == 0)
            return false;
        char[] ch = s.toCharArray();
        boolean[] map = new boolean[len];
        for(int i = 1; i<=len; i++)
        {
            String str = s.substring(0,i);
            if(dict.contains(str))
            {
                map[i-1] = true;
            }
        }
        
        for(int i = 0; i< len; i++)
        {
            if(map[i])
            {
                for(int j = i+2; j<=len; j++)
                {
                    String str = s.substring(i+1, j);
                    if(dict.contains(str))
                    {
                        map[j-1] = true;
                    }
                }
            }
        }
        return map[len-1];
        
    }
    
}
