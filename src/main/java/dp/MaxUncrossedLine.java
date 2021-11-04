package dp;

public class MaxUncrossedLine {
  // 1035

  public static int maxUncrossedLines(int[] A, int[] B) {

    int lengthA = A.length;
    int lengthB = B.length;
    int[][] dp = new int[lengthA + 1][lengthB + 1];
    int ans = 0;
    for (int i = lengthA - 1; i >= 0; i--) {
      for (int j = lengthB - 1; j >= 0; j--) {
        if (A[i] == B[j]) {
          dp[i][j] = dp[i + 1][j + 1] + 1;
          // ans = Math.max(ans,dp[i][j]);
        } else {
          dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
        }
        ans = Math.max(ans, dp[i][j]);
      }
    }

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(String.valueOf(dp[i][j]) + '.');
      }
      System.out.println();
    }

    return ans;
  }

  public static void main(String[] args) {
    int res = maxUncrossedLines(new int[] {1, 4, 2}, new int[] {1, 2, 4});
    System.out.println(res);

    //        int[] test = new int[]{1,2}; /
  }
}
