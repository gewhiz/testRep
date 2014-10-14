//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

//For example, 
//Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.



public class Solution {
    public int trap(int[] A) {
        int pre = 0;
        int pos = A.length -1;
        int left = 0;
        int right = 0;
        int water = 0;
        while(pre<pos)
        {
            left = A[pre] > left? A[pre] : left;
            right = A[pos] >right? A[pos] :right;
            if(right>left)
            {
                water+= left - A[pre];
                pre++;
            }
            else
            {
                water+= right -A[pos];
                pos--;
            }
        }
        return water;
    }
}
