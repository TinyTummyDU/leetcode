package waysOfSorting;

import java.util.Arrays;
import java.util.List;

public class QuickSort {

  public static void quick_Sort(Integer[] arr, int begin, int end) {
    if (begin >= end) return;
    int tmp = arr[begin];
    int i = begin;
    int j = end;
    while (i != j) { // i<j
      // 记住 永远是j先动，就是right先动
      while (arr[j] >= tmp && j > i) j--;
      while (arr[i] <= tmp && j > i) i++;
      int t = arr[i];
      arr[i] = arr[j];
      arr[j] = t;
      //            if(j > i){  //不用加这个了，因为循环内部 只有 j>i 和 j=i ， j=i的时候，上面三行语句就是自己和自己换
      //                int t = arr[i];
      //                arr[i] = arr[j];
      //                arr[j] = t;
      //            }
    }
    arr[begin] = arr[j]; // 这里 i j 无所谓，因为只要跳出上面的循环，i==j
    arr[i] = tmp;
    quick_Sort(arr, begin, i - 1);
    quick_Sort(arr, i + 1, end);
  }

  public static void main(String[] args) {
    Integer[] test = {10, 11, 2, 4, 5, 4};
    quick_Sort(test, 0, test.length - 1);
    List<Integer> test1 = Arrays.asList(test);
    System.out.println(test1);
  }
}
