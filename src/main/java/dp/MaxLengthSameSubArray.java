package dp;

public class MaxLengthSameSubArray {

  public static void main(String[] args) {
    int[] new1 = new int[1];
    System.out.println(new1);
    for (int i = 0; i < 5; i++) {
      System.out.println(i);
    }
  }

  public int findLength(int[] A, int[] B) {
    int lengthA = A.length;
    int lengthB = B.length;
    int[][] dp = new int[lengthA + 1][lengthB + 1];
    int ans = 0;
    for (int i = lengthA - 1; i >= 0; i--) {
      for (int j = lengthB - 1; j >= 0; j--) {

        //                dp[i][j] = A[i]==B[j]? dp[i+1][j+1] + 1: 0;
        // 可以替换下面的这个if else
        if (A[i] == B[j]) {
          dp[i][j] = dp[i + 1][j + 1] + 1;
        } else {
          dp[i][j] = 0;
        }
        ans = Math.max(ans, dp[i][j]);
      }
    }

    return ans;
  }
}
