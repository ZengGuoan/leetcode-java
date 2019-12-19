package _349.Intersection_of_Two_Arrays.v1;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 暴力求解：冒泡排序
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> intersection = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int n1 : nums1) {
            set1.add(n1);
        }
        for (int n2 : nums2) {
            if (set1.contains(n2)) {
                intersection.add(n2);
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}
