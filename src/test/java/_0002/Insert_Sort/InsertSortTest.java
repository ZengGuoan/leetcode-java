package _0002.Insert_Sort;

import org.junit.Test;

public class InsertSortTest {
    @Test
    public void test() {
        int[] nums = {2, 1, 7, 3, 4, 1, 2, 1, 1, 6};
        new Solution().insertSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
