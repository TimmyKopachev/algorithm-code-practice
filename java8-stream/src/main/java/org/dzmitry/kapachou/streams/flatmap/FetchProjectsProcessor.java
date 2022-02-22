package org.dzmitry.kapachou.streams.flatmap;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FetchProjectsProcessor {

  public Set<String> fetchProjects(List<Employee> employees) {
    return employees.stream().map(Employee::getProjects).flatMap(Collection::stream)
        .map(Project::getName).collect(Collectors.toSet());
  }


  static class ApplicationRunner {

    public static void main(String[] args) {
      System.out.println("------------ Stream -> FlatMap()");
      var employees =
          List.of(new Employee("Dzmitry", List.of(new Project("Datalex"), new Project("AHML"))),
              new Employee("Roma", List.of(new Project("Datalex"), new Project("Ticketmaster"))),
              new Employee("Viktor", List.of(new Project("BNY Mellon"))));
      System.out.println(new FetchProjectsProcessor().fetchProjects(employees));
    }
  }
}
