package _18._4Sum;

import org.junit.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(lists);
    }
}
