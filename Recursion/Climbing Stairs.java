//You are climbing a stair case. It takes n steps to reach to the top.

//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


public class Solution {
    public int climbStairs(int n) {
        if(n<=0)
            return 0;
        if(n == 1)
            return 1;
        if(n==2)
            return 2;
        
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i<n; i++)
        {
            arr[i] = arr[i-1] + arr[i-2];
        }
        
        return arr[n-2] + arr[n-1];
        
    }
}
