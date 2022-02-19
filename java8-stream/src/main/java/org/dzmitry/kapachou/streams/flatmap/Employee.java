package org.dzmitry.kapachou.streams.flatmap;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

  private String name;
  private List<Project> projects;
}
