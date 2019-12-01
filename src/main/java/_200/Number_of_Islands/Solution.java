package _200.Number_of_Islands;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
    Position[][] roots;

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
        roots = new Position[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                roots[i][j] = new Position(i, j);
            }
        }

        Set<Position> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                if (i > 0 && grid[i - 1][j] == '1') {
                    Position union = union(i - 1, j, i, j);
                    set.remove(roots[i - 1][j]);
                    set.remove(roots[i][j]);
                    set.add(union);
                }
                if (j > 0 && grid[i][j - 1] == '1') {
                    Position union = union(i, j - 1, i, j);
                    set.remove(roots[i][j - 1]);
                    set.remove(roots[i][j]);
                    set.add(union);
                }
                set.add(findRoot(i, j));
            }
        }
        return set.size();
    }

    /**
     * 获取root
     *
     * @param x
     * @param y
     * @return
     */
    public Position findRoot(int x, int y) {
        // 获取 position: x,y 的root
        int i = x;
        int j = y;
        Position root = roots[i][j];
        while (!root.rootIsCurPosition(i, j)) {
            i = root.x;
            j = root.y;
            root = roots[i][j];
        }
        // 缩短路径，将路径上的所有节点的root全部赋为找到root
        Position parent = roots[x][y];
        while (!parent.rootIsCurPosition(x, y)) {
            Position tmpPosition = roots[x][y]; // 暂存当前节点的上一个节点
            roots[x][y] = root;
            parent = tmpPosition;
            x = parent.x;
            y = parent.y;
        }
        return root;
    }

    /**
     * 合并
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public Position union(int x1, int y1, int x2, int y2) {
        Position root1 = findRoot(x1, y1);
        Position root2 = findRoot(x2, y2);
        roots[root2.x][root2.y] = root1;
        return root1;
    }

    class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean rootIsCurPosition(int x, int y) {
            return this.x == x && this.y == y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x &&
                    y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        char[][] grids = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int result = new Solution().numIslands(grids);
        System.out.println(result);
    }
}
