package _5.Longest_Palindromic_Substring.v1;

public class Solution {
    private static final String EMPTY = "";

    /**
     * 动态规划
     *
     * 1. 状态定义
     *  f(x) = 以x元素坐标为中心的回文
     * 2. 状态转移方程
     *  f(x) = f(2 * x - i) + f(x) + f(i), x = 0 ~ i
     *
     * 时间复杂度O(n^2)
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        // 加上这个判断勉强跑过了
        if (len == 0 || s.replace(String.valueOf(s.charAt(0)), "").length() == 0) {
            return s;
        }
        String[] palindrome = new String[2 * len + 1];
        String max = "";
        for (int i = 0; i < 2 * len + 1; i++) {
            char iCh = getChar(s, i);
            setChar(palindrome, s, i);
            for (int j = 0; j <= i; j++) {
                int before = 2 * j - i;
                if (before < 0 || getChar(s, before) != iCh || !needPalindrome(j, i, palindrome[j])) {
                    continue;
                }
                palindrome[j] = iCh + (palindrome[j] == null ? "" : palindrome[j]) + iCh;
                if (palindrome[j].length() > max.length()) {
                    max = palindrome[j];
                }
            }
        }
        return max.replace(String.valueOf(Character.MIN_VALUE), "");
    }

    /**
     * 只有连续的元素是回文才能算是回文
     *
     * @param position 回文中心
     * @param index 最外的字符
     * @param palindrome 当前的回文
     * @return
     */
    private boolean needPalindrome(int position, int index, String palindrome) {
        int curLen = palindrome == null ? 0 : palindrome.length();
        return index - position == curLen / 2 + 1;
    }

    /**
     * index是填充后的坐标，s是为填充的字符串，获取对应的字符需要进行转换
     *
     * @param s
     * @param index
     * @return
     */
    private char getChar(String s, int index) {
        if (index % 2 == 0) {
            return Character.MIN_VALUE;
        }
        return s.charAt(index / 2);
    }

    private void setChar(String[] palindrome, String s, int index) {
        palindrome[index] = index % 2 == 0 ? EMPTY : String.valueOf(s.charAt(index / 2));
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println("len:" + s.length());
        String result = new Solution().longestPalindrome(s);
        System.out.println(result);
        System.out.println("len:" + result.length());
    }
}
