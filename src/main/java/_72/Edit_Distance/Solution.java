package _72.Edit_Distance;

public class Solution {
    /**
     * 动态规划
     * 1. 状态定义：
     *  f(i, j)=word1的前i个字符转变成world2的前j个字符最少的步骤
     * 2. 状态转移方程：
     *  a. word1[i] == word2[j]:
     *      f(i ,j)= f(i - 1, j - 1)
     *  b. word1[i] != word2[j]:
     *      f(i, j)=min{
     *          f(i - 1, j) + 1,
     *          f(i, j - 1) + 1,
     *          f(i - 1, j - 1) + 1
     *      }
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        // step[0][0]表示两个字符串都是空串
        int[][] step = new int[word1.length() + 1][word2.length() + 1];
        // 初始化开始值
        // 当word2为空串的时候，初始化
        for (int i = 1; i < word1.length() + 1; i++) {
            step[i][0] = i;
        }
        // 当word1为空串的时候，初始化
        for (int i = 1; i < word2.length() + 1; i++) {
            step[0][i] = i;
        }
        // 动态规划逻辑
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    step[i][j] = step[i - 1][j - 1];
                } else {
                    step[i][j] = Math.min(Math.min(step[i - 1][j], step[i][j - 1]), step[i - 1][j - 1]) + 1;
                }
            }
        }
        return step[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        int result = new Solution().minDistance("horse", "ros");
        System.out.println(result);
    }
}
