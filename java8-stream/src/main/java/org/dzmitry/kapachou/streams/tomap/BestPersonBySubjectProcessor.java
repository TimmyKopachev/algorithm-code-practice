package org.dzmitry.kapachou.streams.tomap;

import static org.dzmitry.kapachou.streams.tomap.Subject.ENGLISH;
import static org.dzmitry.kapachou.streams.tomap.Subject.MATH;
import static org.dzmitry.kapachou.streams.tomap.Subject.PROGRAMMING;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class BestPersonBySubjectProcessor {

  public static void main(String[] args) {
    List<Person> people =
        List.of(new Person("Timmy", Map.of(MATH, 3.2, PROGRAMMING, 9.2, ENGLISH, 7.2)),
            new Person("Ksenya", Map.of(MATH, 6.2, PROGRAMMING, 9.4, ENGLISH, 5.2)),
            new Person("Viktor", Map.of(MATH, 7.7, PROGRAMMING, 9.3, ENGLISH, 6.2)));


    Map<Subject, Person> result = Arrays.stream(Subject.values())
        .collect(Collectors.toMap(
            subject -> subject,
            subject -> people.stream()
                .max(Comparator.comparingDouble(p -> p.getSubjects().get(subject)))
                .stream()
                .findFirst()
                .orElseThrow()
        ));

    result.forEach((key, value) -> System.out.printf("%s : [%s - %s]%n", key.name().toLowerCase(),
        value.getName(), value.getSubjects().get(key)));
  }

}
