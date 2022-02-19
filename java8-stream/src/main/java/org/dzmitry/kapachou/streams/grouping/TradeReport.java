package org.dzmitry.kapachou.streams.grouping;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TradeReport {

  String tradeId;
  List<Integer> errorCodes;

}
