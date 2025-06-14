package org.dzmitry.kapachou.dynamic.trade;

public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2)); // 3
        System.out.println(uniquePaths(3, 7)); // 28
    }

    public static int uniquePaths(int m, int n) {
        // v1
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
        // v2

//        if (m == 1 || n == 1) return 1; // if m == 1 or n == 1 there is only 1 path to get the cell. (right or bottom)
//        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

}
