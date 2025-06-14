package org.dzmitry.kapachou.dynamic.trade.backpack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TradeOptimalTradeProcessor {


  public static class ApplicationRunner {

    public static void main(String[] args) {
      List<Trade> trades = new TradeOptimalTradeProcessor().getValuableTrades(30, getDummyTrades());
      System.out.println("---Profitable Trades:");
      trades.forEach(System.out::println);
      System.out.println("---Total profit:");
      System.out.println(getProfitByTrades(trades));
    }

    // prepare dummy data to verify
    private static List<Trade> getDummyTrades() {
      return List.of(
          new Trade("Apple", 1, 5),
          new Trade("Google", 2, 3),
          new Trade("Bitcoin", 4, 5),
          new Trade("A1", 6, 6));
    }
  }

  // main algorithm
  public List<Trade> getValuableTrades(int budget, List<Trade> trades) {
    var valuableTrades =
        trades.stream().filter(trade -> trade.getFuturePrice() - trade.getCurrentPrice() > 0)
            .collect(Collectors.toList());

    ArrayList<Trade>[] results = new ArrayList[budget + 1];
    Arrays.fill(results, new ArrayList<Trade>());

    for (int i = 1; i <= valuableTrades.size(); i++) {
      Trade trade = valuableTrades.get(i - 1);
      int price = trade.getCurrentPrice();
      for (int j = budget; j >= price; j--) {
        var prevProfit = getProfitByTrades(results[j]);
        var extraProfit = getProfitByTrades(results[j - price]);

        if (prevProfit < extraProfit + trade.getFuturePrice() - trade.getCurrentPrice()) {
          results[j] = new ArrayList<>(results[j - price]);
          results[j].add(trade);
        }
      }
    }
    return results[budget];
  }

  // collect profit by list of Trades
  public static int getProfitByTrades(List<Trade> trades) {
    if (trades.isEmpty()) {
      return 0;
    }
    return trades.stream()
        .reduce(0, (sum, trade) -> sum + trade.getFuturePrice() - trade.getCurrentPrice(),
            Integer::sum);
  }

}
