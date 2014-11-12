//Implement int sqrt(int x).
//Compute and return the square root of x.


public class Solution {
    public int sqrt(int x) {
        int st=0, end = x;
        
        while(st<=end)
        {
            int mid = (st+end)/2;
            if(mid > 46341)
    	    {
    	        end = 46340;
    	        continue;
    	    }
            int res = mid *mid;
            
            if(res == x)
            {
                return mid;
            }
            else if(res>x)
            {
                end = mid-1;
            }
            else
            {
                st = mid+1;
            }
        }
        
        return (st+end)/2;
    }
}
