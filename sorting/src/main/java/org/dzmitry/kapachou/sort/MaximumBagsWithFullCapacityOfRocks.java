package org.dzmitry.kapachou.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumBagsWithFullCapacityOfRocks {

    public static void main(String[] args) {
        System.out.println(maximumBags(new int[] {91,54,63,99,24,45,78}, new int[] {35,32,45,98,6,1,25}, 17));
        System.out.println(maximumBags(new int[] {2,3,4,5}, new int[] {1,2,4,4}, 2));
        System.out.println(maximumBags(new int[] {1}, new int[] {0}, 1));
        System.out.println(maximumBags(new int[] {10, 2, 2}, new int[] {2, 2, 0}, 100));
    }

    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int availableCapacity = 0;
        for (int i = 0; i < n; i++) {
            capacity[i] = capacity[i] - rocks[i];
            availableCapacity += capacity[i];
        }
        if (availableCapacity == additionalRocks) return capacity.length;
        Arrays.sort(capacity);
        for (int i = 0; i < n; i++) {
            additionalRocks -= capacity[i];
            if(additionalRocks < 0){
                return i;
            }
        }
        return capacity.length;
    }

}
