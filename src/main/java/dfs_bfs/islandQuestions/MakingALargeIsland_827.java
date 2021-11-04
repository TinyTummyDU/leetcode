package dfs_bfs.islandQuestions;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName: MakingALargeIsland @Description: todo @Author Yuqi Du @Date 2021/10/27 4:15
 * 下午 @Version 1.0
 */
public class MakingALargeIsland_827 {

  public static void main(String[] args) {
    int[][] test = new int[][] {{1, 1}, {1, 1}};
    System.out.println(largestIsland(test));
  }

  public static int largestIsland(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 1;
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    int index = 2; // from 2, cause 0 and 1 are occupied
    int maxAreaWithoutAdding = 0;
    // first dfs, get every island's area. Initialize map
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          map.put(index, dfs(grid, i, j, index));
          maxAreaWithoutAdding = Math.max(maxAreaWithoutAdding, map.get(index));
          index++;
        }
      }
    }
    if (maxAreaWithoutAdding == 0) return 1;
    int res = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) { // 遍历海洋格子
          HashSet<Integer> hashSet = findNeighbour(grid, i, j); // 把上下左右邻居放入set去重
          if (hashSet.size() < 1) continue; // 如果海洋格子周围没有格子不必计算
          int twoIsland = 1; // 填充这个格子，初始为1，这个变量记录合并岛屿后的面积
          for (Integer o : hashSet) {
            twoIsland += map.get(o); // 该格子填充，则上下左右的陆地的都连接了，通过序号获得面积，加上面积
          }
          res = Math.max(res, twoIsland); // 比较得到最大的面积
        }
      }
    }
    return Math.max(maxAreaWithoutAdding, res); // 有可能全是1，就不用加1了
  }

  private static HashSet<Integer> findNeighbour(int[][] grid, int r, int c) {
    HashSet<Integer> hashSet = new HashSet<>();
    if (inArea(grid, r - 1, c) && grid[r - 1][c] != 0) {
      hashSet.add(grid[r - 1][c]);
    }
    if (inArea(grid, r + 1, c) && grid[r + 1][c] != 0) {
      hashSet.add(grid[r + 1][c]);
    }
    if (inArea(grid, r, c - 1) && grid[r][c - 1] != 0) {
      hashSet.add(grid[r][c - 1]);
    }
    if (inArea(grid, r, c + 1) && grid[r][c + 1] != 0) {
      hashSet.add(grid[r][c + 1]);
    }
    return hashSet;
  }

  private static boolean inArea(int[][] grid, int r, int c) {
    return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
  }

  public static int dfs(int[][] grid, int i, int j, int index) {
    if (!inArea(grid, i, j)) {
      return 0;
    }
    if (grid[i][j] != 1) {
      return 0;
    }
    grid[i][j] = index;
    return 1
        + dfs(grid, i + 1, j, index)
        + dfs(grid, i, j + 1, index)
        + dfs(grid, i, j - 1, index)
        + dfs(grid, i - 1, j, index);
  }
}
