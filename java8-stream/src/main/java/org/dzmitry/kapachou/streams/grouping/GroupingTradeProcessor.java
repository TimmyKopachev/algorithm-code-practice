package org.dzmitry.kapachou.streams.grouping;

import static org.dzmitry.kapachou.streams.grouping.TradeStatus.APPROVED;
import static org.dzmitry.kapachou.streams.grouping.TradeStatus.ERROR;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.Data;

public class GroupingTradeProcessor {

  TradeGroupingByStatus tradeGroupingByStatus = new TradeGroupingByStatus();

  public Map<TradeStatus, List<String>> processTradeReports(List<TradeReport> tradeReports) {
    Map<TradeStatus, List<TradeReport>> groupedTrades =
        tradeReports.stream().collect(Collectors.groupingBy(tradeGroupingByStatus));

    return groupedTrades.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
        entry -> entry.getValue().stream().map(TradeReport::getTradeId)
            .collect(Collectors.toList())));
  }

  @Data
  static class TradeGroupingByStatus implements Function<TradeReport, TradeStatus> {

    Predicate<TradeReport> approvedPredicate =
        (tradeReport) -> tradeReport.getErrorCodes().isEmpty();

    Predicate<TradeReport> errorPredicate = (tradeReport) -> !tradeReport.getErrorCodes().isEmpty();

    @Override
    public TradeStatus apply(TradeReport tradeReport) {
      return (approvedPredicate.test(tradeReport)) ? APPROVED : ERROR;
    }
  }

}
