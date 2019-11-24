package _309.Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

public class Solution {
//    public int maxProfit(int[] prices) {
//        if (prices.length == 0) {
//            return 0;
//        }
//        int[][] mp = new int[prices.length][3];
//        mp[0][1] = -prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            mp[i][0] = Math.max(mp[i - 1][0], mp[i - 1][1] + prices[i]);
//            mp[i][1] = Math.max(mp[i - 1][1], (i < 2 ? 0 : mp[i - 2][0]) - prices[i]);
//        }
//        return mp[prices.length - 1][0];
//    }

    /**
     * 基于上面进行优化，优化使用的内存空间
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int cur0 = 0; // 当前不持有股票的最大收益
        int cur1 = -prices[0]; // 当前持有股票的最大收益
        int before0 = 0; // 上一次卖出股票后的最大收益
        for (int i = 1; i < prices.length; i++) {
            int tmp = cur0;
            cur0 = Math.max(cur0, cur1 + prices[i]);
            cur1 = Math.max(cur1, before0 - prices[i]);
            before0 = tmp;
        }
        return cur0;
    }
}
