package com.dzmitry.kapachou.dynamic.trade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.dzmitry.kapachou.dynamic.trade.Trade;
import org.dzmitry.kapachou.dynamic.trade.TradeOptimalTradeProcessor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OptimalTradeProcessorTest {

  TradeOptimalTradeProcessor tradeOptimalTradeProcessor = new TradeOptimalTradeProcessor();

  @ParameterizedTest
  @MethodSource("dummyTrades")
  void getValuableTrades(int budget, List<Trade> trades, int expectedResult) {
    var result = tradeOptimalTradeProcessor.getValuableTrades(budget, trades);

    System.out.println("---Profitable Trades:");
    result.forEach(System.out::println);
    System.out.println("---Total profit:");
    int profitByTrades = TradeOptimalTradeProcessor.getProfitByTrades(result);
    System.out.println(profitByTrades);

    assertEquals(expectedResult, profitByTrades);
  }

  private static Stream<Arguments> dummyTrades() {
    return Stream.of(
        Arguments.of(
            250,
            List.of(
                Trade.builder().name("Apple").currentPrice(175).futurePrice(200).build(),
                Trade.builder().name("Google").currentPrice(133).futurePrice(125).build(),
                Trade.builder().name("Amazon").currentPrice(109).futurePrice(128).build(),
                Trade.builder().name("Facebook").currentPrice(210).futurePrice(228).build(),
                Trade.builder().name("VK").currentPrice(97).futurePrice(133).build()),
            55),
        Arguments.of(
            500,
            List.of(
                Trade.builder().name("Apple").currentPrice(150).futurePrice(140).build(),
                Trade.builder().name("Google").currentPrice(199).futurePrice(175).build(),
                Trade.builder().name("Amazon").currentPrice(200).futurePrice(199).build(),
                Trade.builder().name("Facebook").currentPrice(168).futurePrice(121).build(),
                Trade.builder().name("VK").currentPrice(153).futurePrice(111).build()),
            0),
        Arguments.of(
            30,
            List.of(
                Trade.builder().name("Apple").currentPrice(1).futurePrice(5).build(),
                Trade.builder().name("Google").currentPrice(2).futurePrice(3).build(),
                Trade.builder().name("Amazon").currentPrice(4).futurePrice(5).build(),
                Trade.builder().name("Facebook").currentPrice(6).futurePrice(6).build()),
            6));
  }

}
