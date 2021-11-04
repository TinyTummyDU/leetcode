package dfs_bfs.islandQuestions;

/**
 * @ClassName: NumOfIslands_200 @Description: todo @Author Yuqi Du @Date 2021/10/26 7:11 下午 @Version
 * 1.0
 */
public class NumOfIslands_200 {

  public int numIslands(char[][] grid) {
    int res = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          res++;
        }
      }
    }
    return res;
  }

  public void dfs(char[][] grid, int row, int column) {
    if ((row < 0) || (row >= grid.length) || (column < 0) || (column >= grid[0].length)) {
      return;
    }
    if (grid[row][column] != '1') {
      return;
    }
    grid[row][column] = '2';
    dfs(grid, row + 1, column);
    dfs(grid, row - 1, column);
    dfs(grid, row, column + 1);
    dfs(grid, row, column - 1);
  }
}
