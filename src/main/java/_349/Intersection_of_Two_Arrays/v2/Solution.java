package _349.Intersection_of_Two_Arrays.v2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    /**
     * 使用内置函数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            set2.add(n);
        }
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int i = 0;
        for (Integer n : set1) {
            result[i ++] = n;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Set<Integer> collect = Arrays.stream(array).boxed().collect(Collectors.toSet());
        System.out.println(collect);
    }
}
