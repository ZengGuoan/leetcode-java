package _22.Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * DFS深度优先搜索
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        getNext("", n, n, resList);
        return resList;
    }

    /**
     * @param cur 在当前已经生成的字符串状态
     * @param left 左括号还能使用的次数
     * @param right 右括号还能使用的次数
     * @param resList 存储结果
     * @return
     */
    private void getNext(String cur, int left, int right, List<String> resList) {
        if (left == 0 && right == 0) {
            resList.add(cur);
            return;
        }
        if (left - 1 >= 0) {
            getNext(cur + "(", left - 1, right, resList);
        }
        if (left >= 0 && left < right) {
            getNext(cur + ")", left, right - 1, resList);
        }
    }
}
