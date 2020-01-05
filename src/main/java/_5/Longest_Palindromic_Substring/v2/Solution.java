package _5.Longest_Palindromic_Substring.v2;

public class Solution {
    /**
     * 动态规划
     *
     * 1. 状态定义
     *  f[begin][end]: 坐标i到j字符串是否是回文
     *
     * 2. 状态转移方程
     *  f[begin][end] = f[begin+1][end-1] && (s[begin] == s[end]), (begin <= end)
     *
     *  时间复杂度O(n^2) 相比v1版本运行效率更高
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        int maxLen = 1, maxLeft = 0, maxRight = 0;
        boolean[][] f = new boolean[s.length()][s.length()];
        // 初始状态
        for (int i = 0; i < s.length(); i++) {
            // 单个元素都是回文
            f[i][i] = true;
        }
        for (int end = 1; end < s.length(); end++) {
            for (int begin = 0; begin < end; begin++) {
                if (s.charAt(begin) != s.charAt(end)) {
                    continue;
                }
                if (end - begin < 3 || f[begin + 1][end - 1]) {
                    f[begin][end] = true;
                    if (end - begin + 1 > maxLen) {
                        maxLen = end - begin + 1;
                        maxLeft = begin;
                        maxRight = end;
                    }
                }
            }
        }
        return s.substring(maxLeft, maxRight + 1);
    }
}
