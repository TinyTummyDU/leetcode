package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniqueOccurrences {

  public static boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> m = new HashMap<>();
    for (int i : arr) {
      m.put(i, m.getOrDefault(i, 0) + 1);
    }
    int[] list = new int[m.keySet().size()];
    int o = 0;
    for (int i : m.keySet()) {
      list[o++] = m.get(i);
    }
    Arrays.sort(list);

    for (int j = 1; j < list.length; j++) {
      if (list[j] <= list[j - 1]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {

    int[] arr = new int[] {1, 2};
    System.out.println(uniqueOccurrences(arr));
    int[] arr1 = new int[] {1, 2, 3, 4, 5};
    int i = 0;
    arr1[i++] = 10;
    for (int j : arr1) {
      System.out.println(j);
    }
  }
}
