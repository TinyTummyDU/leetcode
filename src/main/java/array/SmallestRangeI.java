package array;

public class SmallestRangeI {

  public int smallestRangeI(int[] A, int K) {
    int min = A[0], max = A[0];
    for (int i : A) {
      if (i > max) {
        max = i;
      } else if (i < min) {
        min = i;
      }
    }
    return max - min > 2 * K ? max - min - 2 * K : 0;
  }
}
