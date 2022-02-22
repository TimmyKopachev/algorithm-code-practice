package org.dzmitry.kapachou.streams.parallel;

import java.util.ArrayList;
import java.util.List;

public class ParallelProcessor {

  public static List<Player> getGeneratedPlayers() {
    List<Player> players = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      players.add(Player.generatePlayer(i));
    }
    return players;
  }


  static class ApplicationRunner {

    public static void main(String[] args) {
      System.out.println("------------ Stream -> Parallel()");

      getGeneratedPlayers().stream().parallel()
          .forEach(player -> System.out.printf("%s displas playerID %s%n", Thread.currentThread().getName(), player.getId()));
    }
  }
}
