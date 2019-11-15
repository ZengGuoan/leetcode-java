package _69.Sqrt_x;

public class Solution {
    public int mySqrt(int x) {
        double left = 0, right = x, mid = 0;
        // 只需要判断整数是否固定在某个区间就可以了
        while ((int) left < (int) right) {
            mid = (left + right) / 2;
            if (mid * mid > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return (int) mid;
    }
}
