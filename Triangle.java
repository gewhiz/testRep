//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

//For example, given the following triangle
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

//Note:
//Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.


public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n==0)
            return 0;
        int[] map = new int[n];

        for(int i = 0; i<n; i++)
        {
            map[i] = -1;
        }
        
        map[0] = triangle.get(0).get(0);
        for(int i = 1; i<n; i++)
        {
            int[] cp = map.clone();
            List<Integer> list = triangle.get(i);
            for(int k = 0; k< list.size(); k++)
            {
                int pre = 0;
                if(k == 0)
                {
                    pre = cp[0];
                }
                else if(k == (list.size()-1))
                {
                    pre = cp[k-1];
                }
                else
                {
                    pre = cp[k-1] > cp[k]?cp[k]:cp[k-1];
                }
                
                map[k] = pre+list.get(k);
            }
        }
        int min = map[0];
        for(int i = 0; i<n; i++)
        {
            if(map[i] <min)
                min = map[i];
        }
        return min;
    }
}
