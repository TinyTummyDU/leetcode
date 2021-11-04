package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RobotMovingCount_jianzhi_13 {

  //    剑指 Offer 13. 机器人的运动范围
  //    地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
  //    一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
  //    也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
  //    因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

  // https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/
  // 本题与 矩阵中的路径 jianzhi_12_79 类似，是典型的搜索 & 回溯问题。在介绍回溯算法算法前，为提升计算效率，首先讲述两项前置工作： 数位之和计算 、 可达解分析 。

  // BFS 相较于 dfs 是平推的
  public int movingCount(int m, int n, int k) {
    int res = 0;
    boolean[][] visited = new boolean[m][n];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {0, 0, 0, 0});
    while (queue.size() > 0) {
      int[] x = queue.poll();
      int i = x[0], j = x[1], xi = x[2], xj = x[3];
      if (i >= m || j >= n || xi + xj > k || visited[i][j]) continue; // visited一定要放在最后
      visited[i][j] = true;
      res++;
      queue.add(new int[] {i + 1, j, (i + 1) % 10 == 0 ? xi - 8 : xi + 1, xj});
      queue.add(new int[] {i, j + 1, xi, (j + 1) % 10 == 0 ? xj - 8 : xj + 1});
    }
    return res;
  }

  // dfs
  int m, n, k;
  boolean[][] visited1;

  public int movingCount_dfs(int m, int n, int k) {
    this.m = m;
    this.n = n;
    this.k = k;
    this.visited1 = new boolean[m][n];
    return dfs(0, 0, 0, 0);
  }

  public int dfs(int i, int j, int si, int sj) {
    if (i >= m || j >= n || k < si + sj || visited1[i][j]) return 0;
    visited1[i][j] = true;
    return 1
        + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj)
        + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
  }
}
