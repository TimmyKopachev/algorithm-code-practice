package org.dzmitry.kapachou.graph;

import java.util.List;
import lombok.AllArgsConstructor;
import org.dzmitry.kapachou.graph.impl.BellmanFordStrategy;
import org.dzmitry.kapachou.graph.impl.ShortPathStrategy;

@AllArgsConstructor
public class ShortPathProcessor {

  final ShortPathStrategy shortPathStrategy;

  List<Station> computePath(List<Station> stations) {
    return shortPathStrategy.find(stations);
  }

  static class ApplicationRunner {

    public static void main(String[] args) {
      List<Station> stations = List.of();

      ShortPathStrategy shortPathStrategy = new BellmanFordStrategy();
      //ShortPathStrategy shortPathStrategy = new DijkstraStrategy();

      new ShortPathProcessor(shortPathStrategy).computePath(stations);
    }
  }

}
