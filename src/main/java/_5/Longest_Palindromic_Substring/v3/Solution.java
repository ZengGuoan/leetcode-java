package _5.Longest_Palindromic_Substring.v3;

public class Solution {
    private int maxLen = 1; // 最大长度
    private int resLeft = 0;
    private int resRight = 0;

    /**
     * 分别以每个节点为中心进行扩散，记录最大的回文
     *
     * 时间复杂度O(n^2)，但是相比v1版本，效率是有相当大的提升的，v1版本其实是O((2*n)2)
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            // 以i为中心，奇数元素的回文
            searchPalindrome(s, i - 1, i + 1);
            // 以i和i+1为中心，偶数元素的回文
            searchPalindrome(s, i, i + 1);
        }
        return s.substring(resLeft, resRight + 1);
    }

    private void searchPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > maxLen) {
            maxLen = right - left - 1;
            resLeft = left + 1;
            resRight = right - 1;
        }
    }
}
