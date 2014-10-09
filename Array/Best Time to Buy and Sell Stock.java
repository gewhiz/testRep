//Say you have an array for which the ith element is the price of a given stock on day i.

//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.



public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length ==1)
            return 0;
        int low = prices[0];
        int res = 0;

        for(int i = 0; i<prices.length; i++)
        {
            if(prices[i] < low)
                low = prices[i];
            int diff = prices[i] - low;
            if(diff > res)
                res = diff;
        }
        return res;
        
    }
}
