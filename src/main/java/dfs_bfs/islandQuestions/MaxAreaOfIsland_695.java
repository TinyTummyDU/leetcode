package dfs_bfs.islandQuestions;

/**
 * @ClassName: MaxAreaOfIsland @Description: todo @Author Yuqi Du @Date 2021/10/27 3:42 下午 @Version
 * 1.0
 */
public class MaxAreaOfIsland_695 {

  //    You are given an m x n binary matrix grid. An island is a group of 1's
  //        (representing land) connected 4-directionally (horizontal or vertical.)
  //    You may assume all four edges of the grid are surrounded by water.
  //    The area of an island is the number of cells with a value 1 in the island.
  //    Return the maximum area of an island in grid. If there is no island, return 0.

  public int maxAreaOfIsland(int[][] grid) {
    int maxAreaOfOneIsland = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          maxAreaOfOneIsland = Math.max(maxAreaOfOneIsland, dfs(grid, i, j, 0));
        }
      }
    }
    return maxAreaOfOneIsland;
  }

  public int dfs(int[][] grid, int i, int j, int area) {
    if ((i < 0) || (j < 0) || (i >= grid.length) || (j >= grid[0].length)) {
      return area;
    }
    if (grid[i][j] != 1) {
      return area;
    }
    grid[i][j] = 2;
    area++;
    area = dfs(grid, i + 1, j, area);
    area = dfs(grid, i, j + 1, area);
    area = dfs(grid, i - 1, j, area);
    area = dfs(grid, i, j - 1, area);
    return area;
  }

  // 另一种写法
  public int maxAreaOfIsland1(int[][] grid) {
    int res = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] == 1) {
          int a = area(grid, r, c);
          res = Math.max(res, a);
        }
      }
    }
    return res;
  }

  int area(int[][] grid, int r, int c) {
    if (!inArea(grid, r, c)) {
      return 0;
    }
    if (grid[r][c] != 1) {
      return 0;
    }
    grid[r][c] = 2;

    return 1
        + area(grid, r - 1, c)
        + area(grid, r + 1, c)
        + area(grid, r, c - 1)
        + area(grid, r, c + 1);
  }

  boolean inArea(int[][] grid, int r, int c) {
    return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
  }
}
