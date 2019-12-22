package _136.Single_Number;

public class Solution {
    /**
     * 只有一个元素出现过一次，其余元素均出现两次，直接进行异或
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
