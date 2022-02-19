package org.dzmitry.kapachou.streams.flatmap;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FetchProjectsProcessor {

  public Set<String> fetchProjects(List<Employee> employees) {
    return employees.stream().map(Employee::getProjects)
        .flatMap(Collection::stream)
        .map(Project::getName)
        .collect(Collectors.toSet());
  }
}
