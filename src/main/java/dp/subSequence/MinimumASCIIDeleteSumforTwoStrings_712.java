package dp.subSequence;

/**
 * @ClassName: MinimumASCIIDeleteSumforTwoStrings_1143 @Description: todo @Author Yuqi Du @Date
 * 2021/11/8 2:04 下午 @Version 1.0
 */
public class MinimumASCIIDeleteSumforTwoStrings_712 {

  // orignial form 1143
  public int minimumDeleteSum(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    int[][] dp = new int[m + 1][n + 1];
    int sum1 = 0;
    for (int i = 0; i < m; i++) {
      sum1 += (int) s1.charAt(i);
    }
    int sum2 = 0;
    for (int i = 0; i < n; i++) {
      sum2 += (int) s2.charAt(i);
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        char c1 = s1.charAt(i - 1);
        char c2 = s2.charAt(j - 1);
        if (c1 == c2) {
          dp[i][j] = dp[i - 1][j - 1] + (int) c1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return sum1 + sum2 - 2 * dp[m][n];
  }
}
