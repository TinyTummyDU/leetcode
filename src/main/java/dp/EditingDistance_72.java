package dp;

public class EditingDistance_72 {

  // 编辑距离，编辑距离算法被数据科学家广泛应用，是用作机器翻译和语音识别评价标准的基本算法。
  // 最直观的方法是暴力检查所有可能的编辑方法，取最短的一个。所有可能的编辑方法达到指数级，
  // 但我们不需要进行这么多计算，因为我们只需要找到距离最短的序列而不是所有可能的序列。

  public int minDistance(String word1, String word2) {
    int len1 = word1.length();
    int len2 = word2.length();
    int[][] dp = new int[len1 + 1][len2 + 1];

    for (int i = 0; i <= len1; i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j <= len2; j++) {
      dp[0][j] = j;
    }
    for (int i = 1; i <= len1; i++) {
      for (int j = 1; j <= len2; j++) {
        // 删除操作：dp[i - 1][j]
        // 增加操作：dp[i][j - 1]
        // 替换操作：dp[i - 1][j - 1]
        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
        //                dp[i][j] = Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+1));
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          //                    dp[i][j] =
          // Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]));
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
        }
      }
    }
    return dp[len1][len2];
  }
}
