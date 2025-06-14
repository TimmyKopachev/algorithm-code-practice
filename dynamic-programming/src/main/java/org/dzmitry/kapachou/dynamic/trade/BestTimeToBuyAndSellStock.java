package org.dzmitry.kapachou.dynamic.trade;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4})); // 5
        System.out.println(maxProfit(new int[] {7,6,4,3,1})); // 0
        System.out.println(maxProfit(new int[] {1, 2})); // 1
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0], maxProfit = 0;
        if (prices.length < 2) {
            return 0;
        }
        for (int i = 1 ; i < n ; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            }
        }
        return maxProfit;
    }

    // brute force
    public static int maxProfit_v1(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        for (int i = n - 2 ; i >= 0 ; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i] = Math.max(prices[j] - prices[i], Math.max(dp[i], dp[i + 1]));
            }
        }
        return dp[0];
    }
}
