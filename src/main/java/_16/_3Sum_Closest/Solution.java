package _16._3Sum_Closest;

import java.util.Arrays;

public class Solution {
    /**
     * 先选中一个元素，剩余的数组使用前后指针
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int begin = i + 1, end = nums.length - 1;
            while (begin < end) {
                int tmp = nums[begin] + nums[end] + nums[i];
                if (tmp == target) {
                    return target;
                }
                if (tmp < target) {
                    begin++;
                    // 减少不必要的循环
//                    while (begin < end - 1 && nums[begin] == nums[begin + 1]) {
//                        begin++;
//                    }
                } else {
                    end--;
                    // 减少不必要的循环
//                    while (begin < end - 1 && nums[end] == nums[end - 1]) {
//                        end--;
//                    }
                }
                if (Math.abs(target - tmp) < Math.abs(target - min)) {
                    min = tmp;
                }
            }
            // 减少不必要的循环
//            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
//                i ++;
//            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 1, 55};
        int result = new Solution().threeSumClosest(nums, 3);
        System.out.println(result);
    }
}
