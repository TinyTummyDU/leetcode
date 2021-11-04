package dfs_bfs.islandQuestions;

/**
 * @ClassName: IslandParameter @Description: todo @Author Yuqi Du @Date 2021/10/27 6:36 下午 @Version
 * 1.0
 */
public class IslandParameter_463 {
  //    You are given row x col grid representing a map where grid[i][j] = 1 represents land and
  // grid[i][j] = 0 represents water.
  //    Grid cells are connected horizontally/vertically (not diagonally). The grid is completely
  // surrounded by water,
  //    and there is exactly one island (i.e., one or more connected land cells).
  //    The island doesn't have "lakes", meaning the water inside isn't connected to the water
  // around the island.
  //    One cell is a square with side length 1. The grid is rectangular, width and height don't
  // exceed 100.
  //    Determine the perimeter of the island.

  public static int islandPerimeter(int[][] grid) {
    if (grid == null) return 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          return dfs(grid, i, j);
        }
      }
    }
    return 0;
  }

  public static int dfs(int[][] grid, int i, int j) {
    if ((i >= grid.length) || (i < 0) || (j >= grid[0].length) || (j < 0)) {
      return 1;
    }
    if (grid[i][j] == 2) {
      return 0;
    }
    if (grid[i][j] == 0) {
      return 1;
    }
    grid[i][j] = 2;
    // 不是2 不是0 那一定是1喽
    return dfs(grid, i + 1, j) + dfs(grid, i, j + 1) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1);
  }

  public static void main(String[] args) {
    int[][] test = new int[][] {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
    System.out.println(islandPerimeter(test));
  }
}
