package _200.Number_of_Islands.v3;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private char[][] grid;
    private boolean[][] visited;
    private int row;
    private int column;
    // 存储坐标(x, y) 的计算值，需要能够通过值得到 (x, y)
    // value = x * row * column + y
    // y = value % (row * column)
    // x = (value - y) / (row * column)
    private Queue<Integer> queue;
    private int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int count = 0;

    /**
     * BFS广度优先搜索
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
        this.queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    visited[i][j] = true;
                    queue.add(i * (row * column) + j);
                    visit();
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * BFS广度优先搜索
     */
    private void visit() {
        while (!queue.isEmpty()) {
            int position = queue.remove();
            int y = position % (row * column);
            int x = (position - y) / (row * column);
            for (int[] dir : direction) {
                int dirX = dir[0];
                int dirY = dir[1];
                if (validPosition(x + dirX, y + dirY)
                        && !visited[x + dirX][y + dirY] && grid[x + dirX][y + dirY] == '1') {
                    visited[x + dirX][y + dirY] = true;
                    queue.add((x + dirX) * row * column + (y + dirY));
                }
            }
        }
    }

    /**
     * 校验坐标是否合法
     *
     * @param x
     * @param y
     * @return
     */
    private boolean validPosition(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < column;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int result = new Solution().numIslands(grid);
        System.out.println(result);
    }
}
