package org.dzmitry.kapachou.streams.parallel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelProcessor {

  public static List<Player> getGeneratedPlayers() {
    List<Player> players = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
      players.add(Player.generatePlayer(i));
    }
    return players;
  }


  static class ApplicationRunner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
      System.out.println("------------ Stream -> Parallel()");
//      // thread 1
//      List<String> playerNames = new ArrayList<>();
//
//      getGeneratedPlayers().stream()
//          .map(Player::getNickname)
//          .forEach(playerNames::add);
//
//      System.out.println(playerNames.size());
//
//      // thread unsafe
//      /* getGeneratedPlayers().parallelStream()
//          .map(Player::getNickname)
//          .forEach(playerNames::add);
//      System.out.println(playerNames.size()); */
//
//      // fix #1
//      playerNames = Collections.synchronizedList(new ArrayList<>());
//      // fix #2
//      List<String> parallelNames = getGeneratedPlayers().parallelStream()
//          .map(Player::getNickname)
//          .collect(Collectors.toList());
//
//      playerNames.addAll(parallelNames);
//      System.out.println(playerNames.size());

//      int result = IntStream.range(0, 1_000_000_000)
//              .boxed()
//              .parallel()
//              .peek(val -> System.out.println(Thread.currentThread().getName()))
//              .reduce((x,y)->x+2*y)
//              .orElse(0);


      Callable<Integer> task = () -> IntStream.range(0, 1_000_000)
              .boxed()
              .parallel()
              .map(x -> x * 5)
              .peek(val -> System.out.println(Thread.currentThread().getName()))
              .reduce((x, y) -> x + 2 * y)
              .orElse(0);

      ForkJoinPool pool = new ForkJoinPool(3);
      int result = pool.submit(task).get();
      System.out.println(result);
    }
  }
}
