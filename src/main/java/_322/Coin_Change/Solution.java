package _322.Coin_Change;

public class Solution {
    /**
     * 动态规划
     * 1. 状态定义：
     *  f(i)=凑成总金额i所需的最少的硬币个数
     * 2. 状态转移方程：
     *  f(i)=min{f(i - coin1), f(i - coin2), ..., f(i - coinN)} + 1
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] moneyCount = new int[amount + 1]; // index:总金额, value:最少的硬币个数
        for (int i = 1; i <= amount; i++) {
            Integer min = null;
            for (int coin : coins) {
                if (i - coin < 0 || moneyCount[i - coin] == -1) {
                    continue;
                }
                if (min == null || min > moneyCount[i - coin]) {
                    min = moneyCount[i - coin];
                }
            }
            moneyCount[i] = min != null ? min + 1 : -1;
        }
        return moneyCount[amount];
    }
}
