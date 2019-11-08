package _122.best_time_to_buy_and_sell_stock_ii;

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
