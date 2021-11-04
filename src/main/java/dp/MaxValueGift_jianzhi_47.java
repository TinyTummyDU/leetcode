package dp;

public class MaxValueGift_jianzhi_47 {

  //    剑指 Offer 47. 礼物的最大价值

  //    在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
  //    你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
  //    给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
  //            0 < grid.length <= 200
  //            0 < grid[0].length <= 200

  public int maxValue(int[][] grid) {
    int rows = grid.length;
    int columns = grid[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (i == 0 && j == 0) {
          continue;
        } else if (i == 0 && j > 0) { // [0,1]的右边
          grid[i][j] = grid[i][j - 1] + grid[i][j];
        } else if (j == 0 && i > 0) { // [0,1]的下边
          grid[i][j] = grid[i - 1][j] + grid[i][j];
        } else {
          grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
        }
      }
    }
    return grid[rows - 1][columns - 1];
  }

  //    以上代码逻辑清晰，和转移方程直接对应，但仍可提升效率：
  //    当grid 矩阵很大时，第一行和第一列的情况仅占极少数，相当循环每轮都冗余了一次判断。
  //    因此，可先初始化矩阵第一行和第一列，再开始遍历递推。

}
