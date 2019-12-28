package _0001.Select_Sort;

import org.junit.Test;

public class SelectSortTest {
    @Test
    public void test() {
        int[] nums = {2, 1, 7, 3, 4, 1, 2, 1, 1, 6};
        new Solution().selectSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
