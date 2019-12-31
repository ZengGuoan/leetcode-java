package _0005.Merge_Sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSortTest {
    @Test
    public void test() {
        int[] nums = {2, 1, 7, 3, 4, 1, 2, 1, 1, 6};
        new Solution().mergeSort(nums);
        List<Integer> result = Arrays.stream(nums).boxed().collect(Collectors.toList());
        System.out.println(result);
    }
}
