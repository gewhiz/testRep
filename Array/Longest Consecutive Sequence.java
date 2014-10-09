//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

//For example,
//Given [100, 4, 200, 1, 3, 2],
//The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

//Your algorithm should run in O(n) complexity.

import java.util.*;
public class Solution {
    public int longestConsecutive(int[] num) {
        if(num.length == 0)
	            return 0;
	        if(num.length ==1)
	            return 1;
	        Hashtable<Integer, Boolean> hs = new Hashtable<Integer, Boolean>();
	        for(int i = 0; i<num.length; i++)
	        {
	            hs.put(num[i], false);
	        }
	        
	        int res = 1;
	        for(int ele: hs.keySet())
	        {
	            if(hs.get(ele))
	                continue;
	            int count = 0;
	            int k = ele;
	            while(hs.containsKey(k))
	            {
	                hs.put(k, true);
	                k++;
	                count++;
	            }
	            k = ele-1;
	            while(hs.containsKey(k))
	            {
	            	hs.put(k, true);
	                k--;
	                count++;
	            }
	            if(count>res)
	                res = count;
	        }
	        return res;
    }
}
