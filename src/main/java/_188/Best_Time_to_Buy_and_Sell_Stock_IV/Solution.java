package _188.Best_Time_to_Buy_and_Sell_Stock_IV;

public class Solution {
    /**
     * 动态规划
     * 1. 状态定义：
     *  f(i, k, j) = 第i天，最多交易k次，持有j股
     * 2. 状态转移方程：
     *  f(i, k, 0) = max {
     *      f(i-1, k, 0),
     *      f(i-1, k, 1) + prices[i]
     *  }
     *  f(i, k, 1) = max {
     *      f(i-1, k, 1),
     *      f(i-1, k-1, 0) - prices[i]
     *  }
     *
     * 初始状态定义：
     *  f(0, 0, 1) = -prices[0]
     *  f(0, 1, 0) = 0
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        // k超过天数，相当于不限交易次数，直接使用不限交易次数的解决方式
        if (k > prices.length / 2) {
            return maxProfit(prices);
        }
        int[][][] mp = new int[prices.length][k + 1][2];
        // 处理 f(0, 0, 1) = -prices[0]
        for (int kk = 0; kk < k + 1; kk++) {
            mp[0][kk][1] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int kk = 1; kk < k + 1; kk++) {
                mp[i][kk][0] = Math.max(mp[i - 1][kk][0], mp[i - 1][kk][1] + prices[i]);
                mp[i][kk][1] = Math.max(mp[i - 1][kk][1], mp[i - 1][kk - 1][0] - prices[i]);
            }
        }
        return mp[prices.length - 1][k][0];
    }

    /**
     * 无限交易次数
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

    public static void main(String[] args) {
        int result = new Solution().maxProfit(2, new int[]{2, 4, 1});
        System.out.println(result);
    }
}
