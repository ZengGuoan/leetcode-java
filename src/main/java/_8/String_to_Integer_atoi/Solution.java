package _8.String_to_Integer_atoi;

public class Solution {
    public int myAtoi(String str) {
        // 1. 去掉前后空格
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        // 2. 确定符号
        int factor = 1;
        if (str.charAt(0) == '-') {
            factor = -1;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }
        // 3. 去掉数字前面的0
        while (str.length() > 0 && str.charAt(0) == '0') {
            str = str.substring(1);
        }
        // 4. 去掉数字后面的非数字
        int endNumIndex = str.length();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                endNumIndex = i;
                break;
            }
        }
        // 5. 超过11个字符长度肯定是超Integer的最大或最小值了
        if (endNumIndex > 11) {
            return factor > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        String numStr = str.substring(0, endNumIndex);
        long result = 0;
        try {
            result = Long.parseLong(numStr) * factor;
        } catch (NumberFormatException e) {

        }
        if (result >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int result = new Solution().myAtoi("   -42");
        System.out.println(result);
    }
}
