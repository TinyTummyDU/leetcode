package dp.subSequence;

/**
 * @ClassName: LargestCommonSubsequence @Description: todo @Author Yuqi Du @Date 2021/11/8 1:38
 * 下午 @Version 1.0
 */
public class LargestCommonSubsequence_1143 {
  public int longestCommonSubsequence(String text1, String text2) {

    int m = text1.length();
    int n = text2.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {

        char c1 = text1.charAt(i);
        char c2 = text2.charAt(j);
        if (c1 == c2) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[m][n];
  }

  public static void main(String[] args) {

    System.out.println("hah");
  }
}
