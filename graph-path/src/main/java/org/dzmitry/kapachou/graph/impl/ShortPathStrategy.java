package org.dzmitry.kapachou.graph.impl;

import java.util.List;
import org.dzmitry.kapachou.graph.Station;

public interface ShortPathStrategy {

  List<Station> find(List<Station> stations);

}
