package org.dzmitry.kapachou.dynamic.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Trade {
  private String name;
  private int currentPrice;
  private int futurePrice;
}
