package _14.Longest_Common_Prefix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        List<Character> commonPrefixs = findCommonPrefixs(strs);
        StringBuffer sb = new StringBuffer();
        for (Character commonPrefix : commonPrefixs) {
            sb.append(commonPrefix);
        }
        return sb.toString();
    }

    private List<Character> findCommonPrefixs(String[] strs) {
        List<Character> commonPrefixs = new ArrayList<>();
        for (int i = 0; i < strs[0].length(); i++) {
            Character curSame = null;
            for (int j = 0; j < strs.length; j++) {
                String str = strs[j];
                if (i >= str.length()) {
                    return commonPrefixs;
                }
                if (curSame == null) {
                    curSame = str.charAt(i);
                } else if (!curSame.equals(str.charAt(i))) {
                    return commonPrefixs;
                }
                if (j == strs.length - 1) {
                    commonPrefixs.add(str.charAt(i));
                }
            }
        }
        return commonPrefixs;
    }

    public static void main(String[] args) {
        String longestCommonPrefix = new Solution().longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(longestCommonPrefix);
    }
}
