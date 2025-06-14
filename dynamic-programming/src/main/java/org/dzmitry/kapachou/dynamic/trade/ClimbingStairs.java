package org.dzmitry.kapachou.dynamic.trade;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(2)); // 2
        System.out.println(climbStairs(3)); // 3
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int result = 1;
        for (int i = 1; i < n; i++) {
            result += i;
        }
        //return fib(n - 1) + fib(n - 2);
        return result;
    }
}
