package org.dzmitry.kapachou.streams;

import java.util.List;
import org.dzmitry.kapachou.streams.filter.FilterPlayerProcessor;
import org.dzmitry.kapachou.streams.filter.Player;
import org.dzmitry.kapachou.streams.flatmap.Employee;
import org.dzmitry.kapachou.streams.flatmap.FetchProjectsProcessor;
import org.dzmitry.kapachou.streams.flatmap.Project;
import org.dzmitry.kapachou.streams.grouping.GroupingTradeProcessor;
import org.dzmitry.kapachou.streams.grouping.TradeReport;

public class ApplicationRunner {

  public static void main(String[] args) {
    System.out.println("------------ Stream -> Filter()");
    var players =
        List.of(new Player(52, "Timmy"), new Player(14, "Denis"), new Player(15, "Viktor"),
            new Player(8, "Sergey"), new Player(36, "Ksenya"));
    System.out.println(new FilterPlayerProcessor().countTeenagers(players));

    System.out.println("------------ Stream -> FlatMap()");
    var employees =
        List.of(new Employee("Dzmitry", List.of(new Project("Datalex"), new Project("AHML"))),
            new Employee("Roma", List.of(new Project("Datalex"), new Project("Ticketmaster"))),
            new Employee("Viktor", List.of(new Project("BNY Mellon"))));
    System.out.println(new FetchProjectsProcessor().fetchProjects(employees));
    ;


    System.out.println("------------ Stream -> GroupingBy()");
    var tradeReports = List.of(new TradeReport("trade-id-1", List.of()),
        new TradeReport("trade-id-2", List.of(111, 1222)),
        new TradeReport("trade-id-3", List.of(112, 1204)),
        new TradeReport("trade-id-4", List.of(604)));

    System.out.println(new GroupingTradeProcessor().processTradeReports(tradeReports));

    // ------------
  }
}
