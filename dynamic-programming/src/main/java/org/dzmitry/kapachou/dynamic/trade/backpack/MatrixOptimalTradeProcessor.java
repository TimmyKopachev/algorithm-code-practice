package org.dzmitry.kapachou.dynamic.trade.backpack;

import java.util.List;

public class MatrixOptimalTradeProcessor {

  static class ApplicationRunner {

    public static void main(String[] args) {
      System.out.println(new MatrixOptimalTradeProcessor().getValuableTrades(30, List.of(1, 2, 4, 6),
          List.of(5, 3, 5, 6)));
    }
  }

  public int getValuableTrades(int budget, List<Integer> current, List<Integer> future) {

    int[][] result = new int[current.size() + 1][budget + 1];

    for (int i = 1; i <= current.size(); i++) {
      int value = current.get(i - 1);
      int profit = future.get(i - 1) - current.get(i - 1);

      for (int j = 1; j <= budget; j++) {
        if (j < value) {
          result[i][j] = result[i - 1][j];
        } else {
          result[i][j] = Math.max(result[i - 1][j], profit + result[i - 1][j - value]);
        }
      }

    }

    return result[current.size()][budget];
  }
}
