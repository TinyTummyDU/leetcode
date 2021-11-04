package dp;

public class MaxGiftValue {

  public int maxValue(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) continue;
        if (i == 0) grid[i][j] += grid[i][j - 1];
        else if (j == 0) grid[i][j] += grid[i - 1][j];
        else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
      }
    }
    return grid[m - 1][n - 1];
  }

  //    以上代码逻辑清晰，和转移方程直接对应，但仍可提升效率：当grid 矩阵很大时，
  // 第一行和第一列的情况仅占极少数，相当循环每轮都冗余了一次判断。因此，可先初始化矩阵第一行和第一列，再开始遍历递推。

  public int maxValue1(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    for (int j = 1; j < n; j++) // 初始化第一行
    grid[0][j] += grid[0][j - 1];
    for (int i = 1; i < m; i++) // 初始化第一列
    grid[i][0] += grid[i - 1][0];
    for (int i = 1; i < m; i++)
      for (int j = 1; j < n; j++) grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
    return grid[m - 1][n - 1];
  }
}
