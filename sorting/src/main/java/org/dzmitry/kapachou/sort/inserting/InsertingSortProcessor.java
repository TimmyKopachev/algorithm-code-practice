package org.dzmitry.kapachou.sort.inserting;

import java.util.Arrays;

public class InsertingSortProcessor {

  public static void main(String[] args) {
    Integer[] data = new Integer[] {12, 14, 22, 7, 65, 9, 28, 86};

    insertingSort(data);
    System.out.println(Arrays.toString(data));
  }

  public static void insertingSort(Integer[] data) {
    for (int i = 1; i < data.length; i++) {
      int j = i;
      Integer current = data[i];
      while (j > 0 && data[j - 1] > current) {
        data[j] = data[j - 1];
        j--;
      }
      data[j] = current;
    }
  }
}
