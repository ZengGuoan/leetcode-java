package _123.Best_Time_to_Buy_and_Sell_Stock_III;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] mp = new int[3][2];
        for (int k = 0; k < 3; k++) {
            mp[k][1] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k < 3; k++) {
                mp[k][0] = Math.max(mp[k][0], mp[k][1] + prices[i]);
                mp[k][1] = Math.max(mp[k][1], mp[k - 1][0] - prices[i]);
            }
        }
        return mp[2][0];
    }
}
