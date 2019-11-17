package _7.Reverse_Integer;

public class Solution {
    public int reverse(long x) {
        int factor = 1;
        if (x < 0) {
            factor = -1;
            x = -x;
        }
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) (factor * result);
    }

    public static void main(String[] args) {
        int reverse = new Solution().reverse(1534236469);
        System.out.println(reverse);
    }
}
