package org.dzmitry.kapachou.sort.counter;

import java.util.Arrays;

public class CounterSortProcessor {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getPeopleByCountSorter(new int[]{3, 5, 3, 3, 1, 2, 2, 2, 4})));
    }

    private static int[] getPeopleByCountSorter(int[] people) {
        int max = 0;
        int n = people.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, people[i]);
        }
        int [] counter = new int[max + 1];
        for (int i = 0; i < n; i ++) {
            counter[people[i]]++;
        }
        int index = 0;
        for (int i = 0; i < counter.length; i ++) {
            if (counter[i] > 0) {
                for (int j = 0; j < counter[i]; j ++) {
                    people[index++] = i;
                }
            }
        }
        return people;
    }
}
