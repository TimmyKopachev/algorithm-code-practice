package org.dzmitry.kapachou.streams.parallel;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Player {

  private int id;
  private int points;
  private String nickname;



  public static Player generatePlayer(int id) {
    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final java.util.Random random = new java.util.Random();
    final Set<String> identifiers = new HashSet<>();

    StringBuilder builder = new StringBuilder();
    while (builder.toString().length() == 0) {
      int length = random.nextInt(5) + 5;
      for (int i = 0; i < length; i++) {
        builder.append(lexicon.charAt(random.nextInt(lexicon.length())));
      }
      if (identifiers.contains(builder.toString())) {
        builder = new StringBuilder();
      }
    }
    return new Player(id, (int) (Math.random() * 100), builder.toString());
  }

}
