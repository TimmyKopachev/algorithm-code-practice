package org.dzmitry.kapachou.streams.parallel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelProcessor {

  public static List<Player> getGeneratedPlayers() {
    List<Player> players = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
      players.add(Player.generatePlayer(i));
    }
    return players;
  }


  static class ApplicationRunner {

    public static void main(String[] args) {
      System.out.println("------------ Stream -> Parallel()");
      // thread 1
      List<String> playerNames = new ArrayList<>();

      getGeneratedPlayers().stream()
          .map(Player::getNickname)
          .forEach(playerNames::add);

      System.out.println(playerNames.size());

      // thread unsafe
      /* getGeneratedPlayers().parallelStream()
          .map(Player::getNickname)
          .forEach(playerNames::add);
      System.out.println(playerNames.size()); */

      // fix #1
      playerNames = Collections.synchronizedList(new ArrayList<>());
      // fix #2
      List<String> parallelNames = getGeneratedPlayers().parallelStream()
          .map(Player::getNickname)
          .collect(Collectors.toList());

      playerNames.addAll(parallelNames);
      System.out.println(playerNames.size());

    }
  }
}
