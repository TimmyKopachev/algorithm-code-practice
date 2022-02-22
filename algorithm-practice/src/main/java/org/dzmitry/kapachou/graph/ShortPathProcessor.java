package org.dzmitry.kapachou.graph;

import java.util.List;
import org.dzmitry.kapachou.graph.impl.ShortPathStrategy;

public class ShortPathProcessor {

  ShortPathStrategy shortPathStrategy;

  List<Station> computePath(List<Station> stations) {
    return shortPathStrategy.find(stations);
  }

}
