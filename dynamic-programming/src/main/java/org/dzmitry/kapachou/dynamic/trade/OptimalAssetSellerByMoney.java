package org.dzmitry.kapachou.dynamic.trade;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OptimalAssetSellerByMoney {

    public static void main(String[] args) {
        // Generate 10 assets for testing
        var assets = IntStream.range(0, 10)
                .mapToObj(i ->
                        new Asset(
                                String.format("qsp-%s", i + 1),
                                1,
                                (int) (Math.random() * 100 + 100)))
                .collect(Collectors.toList());

        var portfolio = new Portfolio(assets, 0.2);
        var result = sellOffAssetsToRaiseCashRequest(portfolio);

        result.forEach(System.out::println);
        System.out.printf("RaisingCash request:<%.2f>%n", portfolio.getRaiseCashRequest());
        System.out.printf("Assets have been sold off by:<%.2f>%n",
                result.stream().mapToDouble(Asset::getMarketValue).sum());
    }

    public static List<Asset> sellOffAssetsToRaiseCashRequest(Portfolio portfolio) {
        List<Asset> sorted = portfolio.getAssets().stream()
                .sorted(Comparator.comparingDouble(Asset::getMarketValue).reversed())
                .collect(Collectors.toList());
        if (sorted.isEmpty()) return Collections.emptyList();

        TreeMap<Double, List<Asset>> dp = new TreeMap<>();
        dp.put(0.0, Collections.emptyList());

        for (Asset trade : sorted) {
            List<Map.Entry<Double, List<Asset>>> currentState = new ArrayList<>(dp.entrySet());

            for (Map.Entry<Double, List<Asset>> entry : currentState) {
                List<Asset> assets = entry.getValue();
                double newSum = entry.getKey() + trade.getMarketValue();
                if (!dp.containsKey(newSum)) {
                    List<Asset> newAssetsList = new ArrayList<>(assets);
                    newAssetsList.add(trade);
                    dp.put(newSum, newAssetsList);
                }
            }
        }
        return Optional.ofNullable(dp.ceilingKey(portfolio.getRaiseCashRequest()))
                .map(dp::get)
                .orElse(Collections.emptyList());
    }


    @Data
    public static class Asset {
        private final String cusip;
        private final double price;
        private final int quantity;
        private double marketValue;

        public Asset(String cusip, double price, int quantity) {
            this.cusip = cusip;
            this.price = price;
            this.quantity = quantity;
            this.marketValue = price * quantity;
        }
    }


    @Data
    @AllArgsConstructor
    public static class Portfolio {

        private final double marketValue;
        private final List<Asset> assets;
        private final double raiseCashRequest;

        public Portfolio(List<Asset> assets, double raiseCashRequestPct) {
            this.assets = assets;
            this.marketValue = assets.stream().mapToDouble(asset -> asset.marketValue).sum();
            this.raiseCashRequest = this.marketValue * raiseCashRequestPct;
        }
    }
}