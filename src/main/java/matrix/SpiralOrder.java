package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

  // 54 螺旋矩阵

  // 按方向模拟
  int INF = 101;

  public static List<Integer> spiralOrder(int[][] matrix) {
    int totalNum = (matrix.length) * (matrix[0].length);
    List<Integer> res = new ArrayList<>();
    int[] current = {0, 0};
    int currentResNum = 0;

    int[] fourSides = {0, matrix[0].length - 1, matrix.length - 1, 0}; // up right down left
    Boolean toRight = true; // 一开始先向右边走
    Boolean toDown = false;
    Boolean toLeft = false;
    Boolean toUp = false;
    while ((toRight || toDown || toLeft || toUp) && (currentResNum < totalNum)) {
      if (toRight) {
        if (current[1] <= fourSides[1]) {
          System.out.println("toRight");
          System.out.println(matrix[current[0]][current[1]]);
          res.add(matrix[current[0]][current[1]]);
          currentResNum++;
          current[1]++;
        } else { // 已经走到边界 current[1]==fourSides[fourSides[1]]
          current[1]--;
          current[0]++; // 往右完了，开始往下走
          toRight = false;
          toDown = true;
          fourSides[0]++; // 往右走完，上边界应该下移 ++
        }
      } else if (toDown) {
        if (current[0] <= fourSides[2]) {
          System.out.println("toDown");
          System.out.println(matrix[current[0]][current[1]]);
          res.add(matrix[current[0]][current[1]]);
          currentResNum++;
          current[0]++;
        } else { // 已经走到边界
          current[0]--;
          current[1]--;
          toDown = false;
          toLeft = true;
          fourSides[1]--;
        }
      } else if (toLeft) {
        if (current[1] >= fourSides[3]) {
          System.out.println("toLeft");
          System.out.println(matrix[current[0]][current[1]]);
          res.add(matrix[current[0]][current[1]]);
          currentResNum++;
          current[1]--;
        } else { // 已经走到边界
          current[1]++;
          current[0]--;
          toLeft = false;
          toUp = true;
          fourSides[2]--;
        }
      } else {
        if (current[0] >= fourSides[0]) {
          System.out.println("toUp");
          System.out.println(fourSides[0]);
          System.out.println(matrix[current[0]][current[1]]);
          res.add(matrix[current[0]][current[1]]);
          currentResNum++;
          current[0]--;
        } else { // 已经走到边界
          current[0]++;
          current[1]++;
          toUp = false;
          toRight = true;
          fourSides[3]++;
        }
      }
    }
    return res;
  }

  // 按圈模拟

  public static void main(String[] args) {
    int[][] test = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    List<Integer> res = spiralOrder(test);
    System.out.println("xxxxxxxxxxxx");
    for (Integer i : res) {
      System.out.println(i);
    }
    System.out.println("haha");
  }

  public List<Integer> spiralOrder1(int[][] mat) {
    List<Integer> ans = new ArrayList<>();
    int m = mat.length, n = mat[0].length;
    circle(mat, 0, 0, m - 1, n - 1, ans);
    return ans;
  }

  // 遍历 以 (x1, y1) 作为左上角，(x2, y2) 作为右下角形成的「圈」
  void circle(int[][] mat, int x1, int y1, int x2, int y2, List<Integer> ans) {
    if (x2 < x1 || y2 < y1) return;

    // 只有一行时，按「行」遍历
    if (x1 == x2) {
      for (int i = y1; i <= y2; i++) ans.add(mat[x1][i]);
      return;
    }
    // 只有一列时，按「列」遍历
    if (y1 == y2) {
      for (int i = x1; i <= x2; i++) ans.add(mat[i][y2]);
      return;
    }

    // 遍历当前「圈」
    for (int i = y1; i < y2; i++) ans.add(mat[x1][i]);
    for (int i = x1; i < x2; i++) ans.add(mat[i][y2]);
    for (int i = y2; i > y1; i--) ans.add(mat[x2][i]);
    for (int i = x2; i > x1; i--) ans.add(mat[i][y1]);

    // 往里收一圈，继续遍历
    circle(mat, x1 + 1, y1 + 1, x2 - 1, y2 - 1, ans);
  }

  public List<Integer> spiralOrder2(int[][] mat) {
    List<Integer> ans = new ArrayList<>();
    int m = mat.length, n = mat[0].length;
    // 定义四个方向
    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    for (int x = 0, y = 0, d = 0, i = 0; i < m * n; i++) {
      ans.add(mat[x][y]);
      mat[x][y] = INF;

      // 下一步要到达的位置
      int nx = x + dirs[d][0], ny = y + dirs[d][1];
      // 如果下一步发生「溢出」或者已经访问过（说明四个方向已经走过一次）
      if (nx < 0 || nx >= m || ny < 0 || ny >= n || mat[nx][ny] == INF) {
        d = (d + 1) % 4;
        nx = x + dirs[d][0];
        ny = y + dirs[d][1];
      }

      x = nx;
      y = ny;
    }
    return ans;
  }
}
