package _121.best_time_to_buy_and_sell_stock;

public class Solution {
    /**
     * 动态规划
     * 1. 状态定义：f(n)=当前从0开始到第n天所能获取的最大利润
     * 2. 转移方程：f(n)=prices[n] - min{prices[0], ..., prices[n]}
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // 存储过程中 min{prices[0], ..., prices[n]}
        int min = prices[0];
        // 存储结果
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
           int cur = prices[i] - min;
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }
}
