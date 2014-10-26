/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0)
            return 0;
        int[] map = new int[len];
        if(s.charAt(0) == '0')
            return 0;
        else
            map[0] = 1;
        boolean lock = false;
        for(int i = 1; i<len; i++)
        {
            char cur = s.charAt(i);
            char pre = s.charAt(i-1);
            if(cur == '0' && !(pre == '1' || pre == '2'))
                return 0;
            if(pre == '1' && cur != '0')
            {
                if(i>1)
                    map[i] = map[i-1]+map[i-2];
                else
                    map[i] = map[i-1] + 1;
                lock = true;
            }
            else if(pre == '2')
            {
                int cval = Character.getNumericValue(cur);
                if(cval<=6 && cval >0){
                    if(i>1)
                        map[i] = map[i-1] + map[i-2];
                    else
                        map[i] = map[i-1] +1;
                    lock = true;
                }
                else{
                    map[i] = map[i-1];
                    lock = false;
                }
            }
            else if(cur == '0')
            {
                if(lock)
                    map[i] = map[i-1]-1;
                else
                    map[i] = map[i-1];
                lock = true;
            }
            else
            {
                map[i] = map[i-1];
                lock = false;
            }
        }
        return map[len-1];
        
    }
}
