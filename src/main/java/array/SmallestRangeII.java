package array;

import java.util.Arrays;

public class SmallestRangeII {

  public int smallestRangeII(int[] A, int K) {

    Arrays.sort(A);
    int length = A.length;
    int res = A[length - 1] - A[0];

    int max = 0;
    int min = 0;
    for (int i = 0; i < length - 1; i++) {
      max = Math.max(A[i], A[length - 1]);
      min = Math.min(A[0], A[i + 1]);
      res = Math.min(res, max - min);
    }
    return res;
  }
}
