package _3.Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 动态规划
     * 1. 状态定义：f(n) = 从index=0开始到index=n(必须包含)不含有重复字符的 最长子串
     * 2. 转移方程：f(n) = f(n - 1) + s.chatAt(n) || s.chatAt(n)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0, curMax = 0;
        // 从这个index开始的连续不重复字符
        int startIndex = 0;
        // 记录字符出现的最新index
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // 当前的字符存在于之前连续的字符串当中
            if (charIndexMap.containsKey(s.charAt(i)) && charIndexMap.get(s.charAt(i)) >= startIndex) {
                startIndex = charIndexMap.get(s.charAt(i)) + 1;
                curMax = i - startIndex + 1;
            } else {
                curMax ++;
            }
            charIndexMap.put(s.charAt(i), i);
            if (curMax > max) {
                max = curMax;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int result = new Solution().lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
    }
}
