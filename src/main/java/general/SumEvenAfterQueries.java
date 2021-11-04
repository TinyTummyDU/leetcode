package general;

public class SumEvenAfterQueries {

  // 985  查询后的偶数和
  public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {

    int len = queries.length;
    int[] ans = new int[len];
    for (int i = 0; i < len; i++) {
      A[queries[i][1]] += queries[i][0];
      ans[i] = findEvenNumber(A);
    }
    return ans;
  }

  private static int findEvenNumber(int[] A) {
    int sum = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] % 2 == 0) {
        sum += A[i];
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    int[] A = {1, 2, 3, 4};
    int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};

    int[] res = sumEvenAfterQueries(A, queries);
    for (int i : res) {
      System.out.println(i);
    }
  }

  // 高效版
  public int[] sumEvenAfterQueries1(int[] A, int[][] queries) {
    int sum = 0;
    for (int num : A) {
      if (num % 2 == 0) {
        sum += num;
      }
    }

    int[] ans = new int[queries.length];

    for (int i = 0; i < queries.length; i++) {
      int val = queries[i][0];
      int index = queries[i][1];
      if (A[index] % 2 == 0) { // 原来就是偶数，就先减掉他
        sum -= A[index];
      }
      A[index] += val;
      if (A[index] % 2 == 0) { // 加回来
        sum += A[index];
      }
      ans[i] = sum;
    }
    return ans;
  }
}
