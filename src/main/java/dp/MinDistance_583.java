package dp;

public class MinDistance_583 {

  // 583. 两个字符串的删除操作
  // 三种方法,关键就是找 最长子序列（不需要相临）长度 lcs
  // res = m + n - 2*lcs

  // https://leetcode-cn.com/problems/delete-operation-for-two-strings/solution/liang-ge-zi-fu-chuan-de-shan-chu-cao-zuo-by-leetco/

  // 递归
  public int minDistance_dfs(String word1, String word2) {
    int len1 = word1.length();
    int len2 = word2.length();
    return len1 + len2 - 2 * dfs(len1, len2, word1, word2);
  }
  // 错误版本
  public int dfs_wrong(int i, int j, String word1, String word2) { // 算的是lcs
    if (i == 0 || j == 0) { // 0的意思是前面没有数字，并不是索引，因此i，j的意思是前面i个数字1
      return 0;
    }
    if (word1.charAt(i) == word2.charAt(j)) {
      return dfs_wrong(i - 1, j - 1, word1, word2) + 1;
    } else {
      return Math.max(dfs_wrong(i - 1, j, word1, word2), dfs_wrong(i, j - 1, word1, word2));
    }
  }

  public int dfs(int i, int j, String word1, String word2) { // 算的是lcs
    if (i == 0 || j == 0) {
      return 0;
    }
    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
      return dfs(i - 1, j - 1, word1, word2) + 1;
    } else {
      return Math.max(dfs(i - 1, j, word1, word2), dfs(i, j - 1, word1, word2));
    }
  }

  // 添加记忆数组，防止递归重复计算
  public int minDistance_dfs_memo(String word1, String word2) {
    int len1 = word1.length();
    int len2 = word2.length();
    int[][] memo = new int[len1 + 1][len2 + 1];
    return len1 + len2 - 2 * dfs_memo(len1, len2, word1, word2, memo);
  }

  public int dfs_memo(int i, int j, String word1, String word2, int[][] memo) { // 算的是lcs
    if (i == 0 || j == 0) {
      return 0;
    }
    if (memo[i][j] > 0) {
      return memo[i][j];
    }
    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
      memo[i][j] = dfs_memo(i - 1, j - 1, word1, word2, memo) + 1;
    } else {
      memo[i][j] =
          Math.max(dfs_memo(i - 1, j, word1, word2, memo), dfs_memo(i, j - 1, word1, word2, memo));
    }
    return memo[i][j];
  }

  // dp with lsc
  public int minDistance_lsc(String word1, String word2) {
    // dp[i][j] 是word1前i和word2前j 的lsc
    int len1 = word1.length();
    int len2 = word2.length();
    int[][] dp = new int[len1 + 1][len2 + 1];
    for (int i = 1; i <= len1; i++) {
      for (int j = 1; j <= len2; j++) { // j代表的是word2的前j个，因此最后一个索引应该是j-1
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
      }
    }
    return len1 + len2 - 2 * dp[len1][len2];
  }

  // dp without lsc
  public int minDistance(String word1, String word2) {
    // dp[i][j] 是word1前i和word2前j 的最少删除次数
    int len1 = word1.length();
    int len2 = word2.length();
    int[][] dp = new int[len1 + 1][len2 + 1];
    for (int i = 0; i <= len1; i++) {
      for (int j = 0; j <= len2; j++) {
        if (i == 0 || j == 0) { // 初始化第一行和第一列
          dp[i][j] = i + j;
        } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1]; // 但前元素i-1和j-1相等，当然不需要删除
        } else { // 注意，上面一定要用else if, 不然 最后一行语句无论   if(i==0||j==0) 是否执行都会 执行， 或者可以
                 // if(i==0||j==0)里面放continue
          dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]); // 不等，我们就一定要删除一个先
        }
      }
    }
    return dp[len1][len2];
  }
}
