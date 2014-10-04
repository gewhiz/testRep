//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...

//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth sequence.

//Note: The sequence of integers will be represented as a string.
public class Solution {
    public String countAndSay(int n) {
        if(n == 1)
        {
            return "1";
        }
        String pre = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int j = Character.getNumericValue(pre.charAt(0));
        if(pre.length() ==1)
        {
        	sb.append("1");
        	sb.append(String.valueOf(j));
        	return sb.toString();
        }
        
        int i = 1;
        int count = 1;
        
        
        while(i<pre.length())
        {
            int t = Character.getNumericValue(pre.charAt(i));

            if(t == j)
            {
                count++;
            }
            else
            {
                sb.append(count);
                sb.append(String.valueOf(j));
                count = 1;
                j = t;
            }
            if(i == (pre.length() -1))
            {
                sb.append(count);
                sb.append(String.valueOf(j));
                break;
            }
            i++;
        }
        return sb.toString();
    }
    

        
    
}
