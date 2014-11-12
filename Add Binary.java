// Given two binary strings, return their sum (also a binary string).

//For example,
//a = "11"
//b = "1"
//Return "100".


public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        if(i > j)
            return addBinary(b, a);
        char[] res = new char[j+1];
        
        boolean carry =false;
        while(j>=0)
        {
            int mm = 0;
            if(i>=0)
            {
                char m = a.charAt(i);
                mm = Character.getNumericValue(m);
            }
            char n = b.charAt(j);
            
            int nn = Character.getNumericValue(n);
            int kk = mm+nn;
            if(carry)
                kk++;
            
            if(kk ==3)
            {
                res[j] = '1';
                carry = true;
            }
            else if(kk == 2)
            {
                res[j] = '0';
                carry = true;
            }
            else if(kk == 1)
            {
                res[j] = '1';
                carry = false;
            }
            else
            {
                res[j] = '0';
                carry = false;
            }
            i--;
            j--;
        }

        if(carry)
            return "1"+new String(res);
        else
            return new String(res);
    }
}
