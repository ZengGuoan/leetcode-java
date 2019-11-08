package _121.best_time_to_buy_and_sell_stock;

public class Solution {
    public int maxProfit(int[] prices) {
        int pre = 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            } else {
                if (pre < sum) {
                    pre = sum;
                }
                sum = 0;
            }
        }
        return pre;
    }
}
