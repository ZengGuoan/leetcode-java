package _122.Best_Time_to_Buy_and_Sell_Stock_II.v1;

public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) { // 把所有上升段的高度累加
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }
}
