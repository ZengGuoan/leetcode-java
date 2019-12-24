package _26.Remove_Duplicates_from_Sorted_Array;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int newIndex = 1;
        int curIndex = 1;
        while (curIndex < nums.length) {
            if (nums[curIndex - 1] == nums[curIndex]) {
                curIndex ++;
            } else {
                nums[newIndex ++] = nums[curIndex ++];
            }
        }
        return newIndex;
    }
}
