//Given a non-negative number represented as an array of digits, plus one to the number.

//The digits are stored such that the most significant digit is at the head of the list.

public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        boolean allNine = true;
        for(int i = 0; i<n; i++)
        {
            if(digits[i] != 9)
            {
                allNine = false;
            }
        }
        
        if(allNine)
        {
            int[] result = new int[n +1];
            result[0] = 1;
            return result;
        }
        
        boolean carry = false;
        int p = n-1;
        if(digits[p] == 9)
        {
            digits[p] = 0;
            carry = true;
        }
        else
        {
            digits[p]++;
            return digits;
        }
        
        p--;
        while(p>=0)
        {
            if(digits[p] == 9 && carry)
            {
                digits[p] = 0;
                carry = true;
            }
            else if(carry)
            {
                digits[p]++;
                carry = false;
            }
            p--;
        }
        return digits;
        
    }
}
