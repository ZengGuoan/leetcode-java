package _200.Number_of_Islands.v2;

public class Solution {
    private char[][] grid;
    private boolean[][] visited; // 已经浏览过的岛屿
    private int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int row;    // 行
    private int column; // 列

    /**
     * DFS
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        this.grid = grid;
        this.row = grid.length;
        this.column = grid[0].length;
        this.visited = new boolean[row][column];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (visited[i][j] || grid[i][j] == '0') {
                    continue;
                }
                visit(i, j);
                count ++;
            }
        }
        return count;
    }

    /**
     * DFS深度优先搜索，找到一个就延四个方向深入搜索
     *
     * @param x
     * @param y
     */
    private void visit(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < direction.length; i++) {
            int dirX = direction[i][0];
            int dirY = direction[i][1];
            if (x + dirX < 0 || x + dirX >= row || y + dirY < 0 || y + dirY >= column
                    || visited[x + dirX][y + dirY] || grid[x + dirX][y + dirY] == '0') {
                continue;
            }
            visit(x + dirX, y + dirY);
        }
    }
}
