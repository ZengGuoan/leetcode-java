package _300.Longest_Increasing_Subsequence.v2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 时间复杂度O(N*logN)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        List<Integer> result = new ArrayList<>();
        result.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            // 当前元素大于数组中的所有元素，添加在尾部
            if (result.get(result.size() - 1) < nums[i]) {
                result.add(nums[i]);
                continue;
            }
            // 二分查找，找到一个元素比当前元素大，前一个元素比当前元素小的元素，替换成当前元素
            int begin = 0, end = result.size() - 1, mid;
            do {
                mid = (begin + end) / 2;
                if (nums[i] > result.get(mid)) {
                    begin = mid + 1;
                } else {
                    end = mid;
                }
            } while (begin < end);
            result.set(begin, nums[i]);
        }
        return result.size();
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 4};
        int result = new Solution().lengthOfLIS(nums);
        System.out.println(result);
    }
}
