package sorting;

public class BottomK {

  // 面试题 17.14. 最小K个数

  // quick sort
  public int[] smallestK(int[] arr, int k) {
    int length = arr.length;
    quickSort(arr, 0, length);
    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = arr[i];
    }
    return res;
  }

  public void quickSort(int[] arr, int begin, int end) {
    if (begin >= end) {
      return;
    }

    int i = begin;
    int j = end;
    int pivot = arr[begin];
    while (i < j) { // i!=j
      while (arr[j] >= pivot && i < j) {
        j--;
      }
      while (arr[i] <= pivot && i < j) {
        i++;
      }
      int swap = arr[i];
      arr[i] = arr[j];
      arr[j] = swap;
    }
    arr[begin] = arr[i];
    arr[i] = pivot;
    quickSort(arr, i + 1, end);
    quickSort(arr, begin, i - 1);
  }
}
