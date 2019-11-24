package _714.Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

public class Solution {
//    public int maxProfit(int[] prices, int fee) {
//        if (prices.length == 0) {
//            return 0;
//        }
//        int[][] mp = new int[prices.length][2];
//        mp[0][1] = -prices[0] - fee;
//        for (int i = 1; i < prices.length; i++) {
//            mp[i][0] = Math.max(mp[i - 1][0], mp[i - 1][1] + prices[i]);
//            mp[i][1] = Math.max(mp[i - 1][1], mp[i - 1][0] - prices[i] - fee);
//        }
//        return mp[prices.length - 1][0];
//    }

    /**
     * 对上面的方法进行优化
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        int cur0 = 0; // 当前不持有股票的最大利益
        int cur1 = -prices[0] - fee; // 当前持有股票的最大利益
        for (int i = 1; i < prices.length; i++) {
            int tmpCur0 = Math.max(cur0, cur1 + prices[i]);
            cur1 = Math.max(cur1, cur0 - prices[i] - fee);
            cur0 = tmpCur0;
        }
        return cur0;
    }
}
