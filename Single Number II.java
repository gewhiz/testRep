//Given an array of integers, every element appears three times except for one. Find that single one.

//Note:
//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


public class Solution {
    public int singleNumber(int[] A) {
    int res = 0;
    int count = 0;

    for (int i=0; i<32; i++){
        count = 0;
        for (int j=0; j<A.length; j++){
            count += ((A[j] >>> i) & 1);
        }

        res = res | ((count % 3) << i);
    }

    return res;
}
}
