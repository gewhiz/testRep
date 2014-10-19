/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
You are responsible to gather all the input requirements up front.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

*/


public class Solution {
    public int atoi(String str) {
        String tr = str.trim();
        if(tr.length() == 0)
            return 0;
        boolean isNeg = false;
        if(tr.charAt(0) == '-')
        {
            isNeg = true;
            tr = tr.substring(1);
        }
        else if(tr.charAt(0) == '+')
        {
            tr = tr.substring(1);
        }
        if(tr.charAt(0)>'9' || tr.charAt(0) <'0')
            return 0;
        
        int len = tr.length();
        Integer res = 0;
        Integer w = 1;
        int i = 0;
        while(i < len)
        {
           if(w.toString().length() == 11)
            {
                if(isNeg)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
            if(w.toString().length() == 10 && tr.charAt(i)<='9' && tr.charAt(i)>='0' )
            {   
                if(res> (Integer.MAX_VALUE/10) )
                {
                    if(isNeg)
                        return Integer.MIN_VALUE;
                    else
                        return Integer.MAX_VALUE;
                }
                if(res == (Integer.MAX_VALUE/10))
                {
                    if(tr.charAt(i)<='7')
                    {
                        int k = Character.getNumericValue(tr.charAt(i));
                        res = res*10+k;
                        if(isNeg)
                            return -res;
                        else
                            return res;
                    }
                    else
                    {
                        if(isNeg)
                            return Integer.MIN_VALUE;
                        else
                            return Integer.MAX_VALUE;
                    }
                }
            }
            if(tr.charAt(i)<='9' && tr.charAt(i)>='0' )
            {
                int k = Character.getNumericValue(tr.charAt(i));
                res = res*10+k;
                w*=10;
            }
            else
            {
                break;
            }
            i++;
        }
        if(isNeg)
            return -res;
        return res;
    }
}
