package _0004.Quick_Sort;

import org.junit.Test;

public class QuickSortTest {
    @Test
    public void test() {
        int[] nums = {2, 1, 7, 3, 4, 1, 2, 1, 1, 6};
        new Solution().quickSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
