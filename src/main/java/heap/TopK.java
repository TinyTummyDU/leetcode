package heap;

public class TopK {
  public int[] getLeastNumbers(int[] arr, int k) {
    if (k == 0) {
      return new int[0];
    } else if (arr.length <= k) {
      return arr;
    }

    // 原地不断划分数组
    partitionArray(arr, 0, arr.length - 1, k);

    // 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = arr[i];
    }
    return res;
  }

  public void partitionArray(int[] arr, int lo, int hi, int k) {
    // 做一次 partition 操作
    int m = partition(arr, lo, hi);
    // 此时数组前 m 个数，就是最小的 m 个数
    if (k == m) {
      // 正好找到最小的 k(m) 个数
      return;
    } else if (k < m) {
      // 最小的 k 个数一定在前 m 个数中，递归划分
      partitionArray(arr, lo, m - 1, k);
    } else {
      // 在右侧数组中寻找最小的 k-m 个数
      partitionArray(arr, m + 1, hi, k);
    }
  }

  public int partition(int[] arr, int lo, int hi) {

    int i = lo;
    int j = hi;
    int pivot = arr[lo];
    while (i < j) {
      while (arr[j] >= pivot && i < j) {
        j--;
      }
      while (arr[i] <= pivot && i < j) {
        i++;
      }
      int swap = arr[j];
      arr[j] = arr[i];
      arr[i] = swap;
    }
    arr[lo] = arr[j];
    arr[j] = pivot;
    return j;
  }
}
