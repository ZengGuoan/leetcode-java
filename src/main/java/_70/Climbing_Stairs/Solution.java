package _70.Climbing_Stairs;

public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1, second = 2, third = -1;
        for (int i = 2; i < n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}
