package org.dzmitry.kapachou.graph.bfs;


public class NumberOfIslands {


    public static void main(String[] args) {
        char[][] grid = {
                {'1', '0', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '0', '0'},
                {'1', '0', '0', '0', '0', '0'},
                {'1', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }


    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    findIslandAndMarkAsCounted(i, j, grid);
                }
            }
        }
        return count;
    }

    private static void findIslandAndMarkAsCounted(int i, int j, char[][] grid) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '*';
            findIslandAndMarkAsCounted(i + 1, j, grid);
            findIslandAndMarkAsCounted(i - 1, j, grid);
            findIslandAndMarkAsCounted(i, j - 1, grid);
            findIslandAndMarkAsCounted(i, j + 1, grid);
        }
    }

}