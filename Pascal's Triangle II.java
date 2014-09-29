//Given an index k, return the kth row of the Pascal's triangle.

//For example, given k = 3,
//Return [1,3,3,1].

//Note:
//Could you optimize your algorithm to use only O(k) extra space?

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res= new ArrayList<Integer>();
        int n = rowIndex;
        if(n < 0)
            return res;
        if(n == 0)
        {
            res.add(1);
            return res;
        }
        int k = 1;
        int[] pre = new int[n+1];
        pre[0] = 1;
        while(k<=n)
        {
            int i = 1;
            int[] temp = new int[n+1];
            temp = pre.clone();
            while(i<k)
            {
                pre[i] = temp[i] + temp[i-1];
                i++;
            }
            pre[k] = 1;
            k++;
        }
        for(int i : pre)
        {
            res.add(i);
        }
        return res;
    }
}
