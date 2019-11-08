package _18._4Sum;

import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        // 先对数组从小打到排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 固定前两个数
                int beforeTwo = nums[i] + nums[j];
                // 从前面固定的两个数之后开始开头和结尾指针
                int start = j + 1;
                int end = nums.length - 1;
                while (start < nums.length && end < nums.length && start < end) {
                    if (start > j + 1 && nums[start] == nums[start - 1]) {
                        start ++;
                        continue;
                    }
                    if (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                        end --;
                        continue;
                    }
                    int endTwo = nums[start] + nums[end];
                    if (beforeTwo == target - endTwo) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                    }
                    if (endTwo < target - beforeTwo) {
                        start ++;
                    } else {
                        end --;
                    }
                }
            }
        }
        return result;
    }
}
