package org.dzmitry.kapachou.dynamic.trade;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println(generate(5)); // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        System.out.println(generate(1)); // 1
    }

    public static List<List<Integer>> generate(int numRows) {
        //List<List<Integer>> dp = new ArrayList<>(numRows - 1);
        int[] dp = new int[numRows + 1];

        for (int i = 1; i <= numRows; i++) {

        }
        return null;
    }
}
