package org.dzmitry.kapachou.streams.filter;

import java.util.List;

public class FilterPlayerProcessor {

  public long countTeenagers(List<Player> players) {
    return players.stream().filter(player -> player.getAge() <= 18).count();
  }

}
