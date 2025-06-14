package org.dzmitry.kapachou.dynamic.trade;

public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(fib(3)); // 2
        System.out.println(fib(2)); // 1
        System.out.println(fib(4)); // 3
    }


    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
