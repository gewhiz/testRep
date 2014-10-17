/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null)
            return false;
        if(s == "")
            return true;
        List<Character> list = new ArrayList<Character>();
        for(int i = 0 ; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            int n = (int)ch;
            if((n>=65 && n<=90)|| (n>96 && n<123) || (ch >='0' && ch <='9'))
            {
                list.add(ch);
            }
        }
        if(list.size() == 0)
            return true;
        int i = 0, j = list.size()-1;
        while(i<j)
        {
            if(Character.toLowerCase(list.get(i)) == Character.toLowerCase(list.get(j)))
            {
                i++;
                j--;
            }
            else
            {
                return false;
            }
        }
        return true;
        
    }
}
