package _200.Number_of_Islands;

public class Solution {
    int[] roots;    // 存储并查集
    int count = 0;  // 岛屿个数

    /**
     * 使用并查集
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        roots = new int[m * n];
        // 初始化并查集
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 并查集节点自己指向自己
                roots[i * n + j] = i * n + j;
                count ++;
            }
        }
        // 遍历所有的岛屿，合并岛屿
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    count --;
                    continue;
                }
                // 与左边的岛屿合并
                if (i > 0 && grid[i - 1][j] == '1') {
                    union((i - 1) * n + j, i * n + j);
                }
                // 与上面的岛屿合并
                if (j > 0 && grid[i][j - 1] == '1') {
                    union(i * n + (j - 1), i * n + j);
                }
            }
        }
        return count;
    }

    /**
     * 获取root
     *
     * @param p
     * @return
     */
    public int findRoot(int p) {
        // 获取root
        int root = p;
        while (root != roots[root]) {
            root = roots[root];
        }
        // 缩短路径，将路径上的所有节点的root全部赋为找到root
        int i = p;
        while (i != roots[i]) {
            int tmp = roots[i];
            roots[i] = root;
            i = tmp;
        }
        return root;
    }

    /**
     * 合并
     *
     * @param p1
     * @param p2
     */
    public void union(int p1, int p2) {
        int root1 = findRoot(p1);
        int root2 = findRoot(p2);
        if (root1 != root2) {
            roots[root2] = root1;
            // 两个岛屿合并，计数减1
            count --;
        }
    }
    public static void main(String[] args) {
        char[][] grids = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int result = new Solution().numIslands(grids);
        System.out.println(result);
    }
}
