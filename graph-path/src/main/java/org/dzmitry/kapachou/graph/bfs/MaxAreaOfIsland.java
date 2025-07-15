package org.dzmitry.kapachou.graph.bfs;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{
                {0, 1, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 0, 1},
                {0, 1, 0, 0, 1}

        }));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    area = Math.max(area, bfs(grid, i, j));
                }
            }
        }
        return area;
    }

    private static int bfs(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + bfs(grid, i + 1, j)
                    + bfs(grid, i - 1, j)
                    + bfs(grid, i, j + 1)
                    + bfs(grid, i, j - 1);
        }
        return 0;
    }
}
