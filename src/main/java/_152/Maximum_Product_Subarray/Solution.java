package _152.Maximum_Product_Subarray;

public class Solution {
    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        // 初始化index=0的情况
        int beforeMax, beforeMin, max;
        max = beforeMax = beforeMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 获取到包括当前index=i元素时的最大连续子序列乘积
            int tmpBeforeMax = Math.max(Math.max(beforeMax * nums[i], beforeMin * nums[i]), nums[i]);
            // 获取到包括当前index=i元素时的最小连续子序列乘积
            int tmpBeforeMin = Math.min(Math.min(beforeMax * nums[i], beforeMin * nums[i]), nums[i]);
            beforeMax = tmpBeforeMax;
            beforeMin = tmpBeforeMin;
            // 记录过程中产生的最大值
            if (beforeMax > max) {
                max = beforeMax;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -3, -2};
        int maxProduct = new Solution().maxProduct(nums);
        System.out.println(maxProduct);
    }
}
