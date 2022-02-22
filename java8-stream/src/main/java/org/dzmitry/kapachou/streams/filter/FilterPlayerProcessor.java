package org.dzmitry.kapachou.streams.filter;

import java.util.List;
import java.util.stream.Collectors;

public class FilterPlayerProcessor {

  public long countTeenagers(List<Player> players) {
    return players.stream().filter(player -> player.getAge() <= 18).count();
  }

  public List<Player> getSecondPairTeenagers(List<Player> players) {
    return players.stream()
        .skip(2)
        .limit(2).collect(Collectors.toList());
  }

  static class ApplicationRunner {

    public static void main(String[] args) {
      System.out.println("------------ Stream -> Filter()");

      var players =
          List.of(new Player(52, "Timmy"), new Player(14, "Denis"), new Player(15, "Viktor"),
              new Player(8, "Sergey"), new Player(36, "Ksenya"));

      System.out.println(new FilterPlayerProcessor().countTeenagers(players));
      System.out.println(new FilterPlayerProcessor().getSecondPairTeenagers(players));


    }
  }

}
