package org.dzmitry.kapachou;

public class BoatToSavePeople {

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        int[] sorted = getPeopleByCountSorter(people);
        int l = 0;
        int r = sorted.length - 1;
        while (l <= r) {
            if (sorted[l] + sorted[r] <= limit) {
                l++;
            }
            r--;
            boats++;
        }

        return boats;
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
