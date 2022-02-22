package org.dzmitry.kapachou.dynamic;

import java.util.List;

public class OptimalTradeProcessor {

  static class ApplicationRunner {

    public static void main(String[] args) {
      System.out.println(new OptimalTradeProcessor().getValuableTrades(30, List.of(1, 2, 4, 6),
          List.of(5, 3, 5, 6)));
    }
  }

  public int getValuableTrades(int budget, List<Integer> current, List<Integer> future) {
    int[] result = new int[budget + 1];

    for (int i = 0; i < current.size(); i++) {

      int value = current.get(i);
      int profit = future.get(i) - current.get(i);

      for (int j = budget; j >= value; j--) {
        result[j] = Math.max(result[j], profit + result[j - value]);
      }
    }
    return result[budget];
  }
}
