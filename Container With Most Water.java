//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
//Find two lines, which together with x-axis forms a container, such that the container contains the most water.

//Note: You may not slant the container.


public class Solution {
    public int maxArea(int[] height) {
        int low = 0, high = height.length-1;
        int maxArea = 0;
        while(low<high)
        {
            int h = height[high] > height[low]? height[low] : height[high];
            int area = (high - low) * h;
            if(area> maxArea)
                maxArea = area;
            if(height[high]> height[low])
            {
                low++;
            }
            else
            {
                high--;
            }
        }
        return maxArea;
    }
}
