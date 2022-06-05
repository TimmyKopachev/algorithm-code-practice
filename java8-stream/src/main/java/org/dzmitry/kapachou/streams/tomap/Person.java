package org.dzmitry.kapachou.streams.tomap;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person {
  private String name;
  private Map<Subject, Double> subjects;
}
