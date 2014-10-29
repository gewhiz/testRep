//Given a string, find the length of the longest substring without repeating characters. 
//For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
//which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for(int i = 0; i<s.length(); i++)
        {
            boolean[] map = new boolean[256];
            for(int j = i; j<s.length(); j++)
            {
                char k = s.charAt(j);
                if(map[(int)k])
                    break;
                map[(int)k] = true;
            }
            int c = 0;
            for(int m = 0; m<256; m++)
            {
                if(map[m])
                    c++;
            }
            if(c>max)
                max = c;
        }
        
        
        return max;
    }
}
