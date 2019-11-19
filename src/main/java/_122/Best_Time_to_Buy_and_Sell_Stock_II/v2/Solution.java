package _122.Best_Time_to_Buy_and_Sell_Stock_II.v2;

public class Solution {
    /**
     * 动态规划
     * 1. 状态定义：f(n)=从0到n天的最大利益
     * 2. 转移方程：f(n)=f(n-1) + (prices[n] > prices[n - 1] ? prices[n] - prices[n - 1] : 0)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int fn = 0;
        for (int i = 1; i < prices.length; i++) {
            fn = fn + (prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0);
        }
        return fn;
    }
}
