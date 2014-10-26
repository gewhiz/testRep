/*
Given n non-negative integers representing 
the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
For example,
Given height = [2,1,5,6,2,3],
return 10.
*/

public class Solution {
    public int largestRectangleArea(int[] height) {
        int len= height.length;
        int max = 0;
        Stack<Integer> st = new Stack<Integer>();
        int i = 0;
        while(i<len)
        {
            int cur = height[i];
            if (st.isEmpty() || cur > height[st.peek()])
            {
                st.push(i);
                i++;
            }
            else
            {
                int k = st.pop();
                int area = height[k] * (st.isEmpty() ? i : i - st.peek() - 1);
                if(area > max)
                {
                    max = area;
                }
            }
        }
        
        while (!st.isEmpty())
        {
            int k = st.pop();
                int area = height[k] * (st.isEmpty() ? i : i - st.peek() - 1);
                if(area > max)
                {
                    max = area;
                }
        }
        return max;
    }
}
