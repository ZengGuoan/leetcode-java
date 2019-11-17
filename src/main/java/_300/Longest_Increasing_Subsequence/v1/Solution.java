package _300.Longest_Increasing_Subsequence.v1;

import java.util.Arrays;

public class Solution {
    /**
     * 时间复杂度O(n^2)
     *
     * 动态规划
     * 1. 状态定义：f(n)=从index=0到index=n中最长的上升子序列
     * 2. 转移方程：f(n)=f(x)+num[n], {f(0), f(1), ..., f(n-1)}过滤最后一个元素小于nums[n],并从中找出最长的上升子序列的f(x)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int[][] fn = new int[nums.length][];
        fn[0] = new int[]{nums[0]};
        for (int i = 1; i < nums.length; i++) {
            int[] beforeMaxLengthOfLIS = findBeforeMaxLengthOfLIS(fn, i, nums[i]);
            int newSize = beforeMaxLengthOfLIS != null ? beforeMaxLengthOfLIS.length + 1 : 1;
            int[] curLIS;
            if (beforeMaxLengthOfLIS == null) {
                curLIS = new int[1];
            } else {
                curLIS = Arrays.copyOf(beforeMaxLengthOfLIS, newSize);
            }
            curLIS[newSize - 1] = nums[i];
            fn[i] = curLIS;
            if (newSize > max) {
                max = newSize;
            }
        }
        return max;
    }

    /**
     * {f(0), f(1), ..., f(n-1)}过滤最后一个元素小于nums[n],并从中找出最长的上升子序列的f(x)
     *
     * @param fn
     * @param curNum
     * @return
     */
    private int[] findBeforeMaxLengthOfLIS(int[][] fn, int endIndex, int curNum) {
        int[] maxLength = null;
        int max = 0;
        for (int i = 0; i < fn.length; i++) {
            int[] list = fn[i];
            if (i >= endIndex || list[list.length - 1] >= curNum) {
                continue;
            }
            if (list.length > max) {
                max = list.length;
                maxLength = list;
            }
        }
        return maxLength;
    }
}
