package general;

import java.util.List;

public class MinimumTotalTriangle {

  // 120

  public int minimumTotal(List<List<Integer>> triangle) {

    int size = triangle.size();
    int res = 0;
    int next1 = 0;
    int next2 = 0;

    for (int i = 0; i < size; i++) {
      if (triangle.get(i).get(next1) < triangle.get(i).get(next2)) {
        res += triangle.get(i).get(next1);
      } else {
        res += triangle.get(i).get(next2);
      }
      next1 = i;
      next2 = i + 1;
    }
    return res;
  }

  // 递归
  public int minimumTotal1(List<List<Integer>> triangle) {
    return dfs(triangle, 0, 0);
  }

  private int dfs(List<List<Integer>> triangle, int i, int j) {
    if (i == triangle.size()) {
      return 0;
    }
    return Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
  }

  // dp
  public int minimumTotal2(List<List<Integer>> triangle) {
    int n = triangle.size();
    // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
    int[][] dp = new int[n + 1][n + 1];
    // 从三角形的最后一行开始递推。
    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
      }
    }
    return dp[0][0];
  }
}
