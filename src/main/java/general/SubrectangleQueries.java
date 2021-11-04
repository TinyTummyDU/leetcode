package general;

public class SubrectangleQueries {

  // 1476
  // 子矩形查询
  int[][] rectangle;

  public SubrectangleQueries(int[][] rectangle) {
    this.rectangle = rectangle;
  }

  public static void main(String[] args) {
    int[][] a = new int[][] {{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}};
    SubrectangleQueries subrectangleQueries = new SubrectangleQueries(a);
    // 返回 1
    System.out.println(subrectangleQueries.getValue(0, 2));
    subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);

    System.out.println(subrectangleQueries.getValue(0, 2));
  }

  public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
    for (int i = row1; i <= row2; i++) {
      for (int j = col1; j <= col2; j++) {
        rectangle[i][j] = newValue;
      }
    }
  }

  public int getValue(int row, int col) {
    System.out.println(111);
    return rectangle[row][col];
  }

  //    这道题暴力模拟就可以通过，不多说了。但是，这个问题可以不暴力更新矩阵的内容。
  //    我们可以设置一个history的数组，记录每次调用updateSubrectangle的信息。这样，updateSubrectangle的复杂度是 O(1) 的。
  //    相应的，在 getValue 的过程中，我们只需要倒序查找我们记录的 history，
  //    如果发现我们要查找的 (row, col) 包含在某一次历史更新的位置中，
  //    直接返回这个历史更新值就好了。否则的，历史更新没有动过这个位置，返回原始矩阵中这个位置的值。

}

/**
 * Your SubrectangleQueries object will be instantiated and called as such: SubrectangleQueries obj
 * = new SubrectangleQueries(rectangle); obj.updateSubrectangle(row1,col1,row2,col2,newValue); int
 * param_2 = obj.getValue(row,col);
 */
