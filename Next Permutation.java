/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/

public class Solution {
    public void nextPermutation(int[] num) {
        int len = num.length;
        if(len ==1)
            return;
        int i = len-1;
        for(; i>0; i--)
        {
            if(num[i]>num[i-1])
            {
                int k = i;
                int base = num[i-1];
                int diff = num[i] - num[i-1];
                num[i-1] = num[i];
                num[i] = base;
                
                while(k<len)
                {
                    if(num[k]>base && (num[k] - base)<diff)
                    {
                        int m = num[i-1];
                        num[i-1] = num[k];
                        num[k] = m;
                        diff = num[k] - base;
                    }
                    k++;
                }
                break;
            }
        }
        
        for(int m = i; m<len; m++)
        {
            for(int n = m; n<len; n++)
            {
                if(num[m]>num[n])
                {
                    int t = num[m];
                    num[m] = num[n];
                    num[n] = t;
                }
            }
        }

    }
}
