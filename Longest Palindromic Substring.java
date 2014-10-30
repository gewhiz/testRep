//Given a string S, find the longest palindromic substring in S. 
//You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len == 0)
            return "";
        start = 0;
        count = 0;
        for(int i = 0; i<len-1;i++)
        {
            checkdouble(s, i);
            checkSingle(s, i);
        }
        
        return s.substring(start, start+count+1);
            
    }
    
    int start;
    int count;
    
    void checkdouble(String s, int i)
    {
        if(s.charAt(i+1) != s.charAt(i))
            return;
        int m = i;
        int n = i+1;
        
        while(m>=0 && n<s.length())
        {
            if(s.charAt(m) != s.charAt(n))
            {   m++;
                n--;
                break;
            }
            m--;
            n++;
        }
        if(m<0 || n==s.length()){
            m++;        
            n--;
        }
        int diff = n-m;
        if(diff > count)
        {
            start = m;
            count = diff; 
        }
    }
    
    void checkSingle(String s, int i)
    {
        if(i==0)
            return;
        if(s.charAt(i-1) != s.charAt(i+1))
            return;
        int m = i-1;
        int n = i+1;
        while(m>=0 && n<s.length())
        {
            if(s.charAt(m) != s.charAt(n))
            {
                 n--;
                 m++;
                 break;
            }
                
            m--;
            n++;
        }
        if(m<0 || n==s.length()){
            m++;        
            n--;
        }

        int diff = n-m;
        if(diff>count)
        {
            start = m;
            count = diff;
        }
    }
    
    
}
