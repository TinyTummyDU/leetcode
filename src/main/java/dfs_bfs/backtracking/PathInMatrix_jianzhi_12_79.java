package dfs_bfs.backtracking;

public class PathInMatrix_jianzhi_12_79 {

  public boolean exist(char[][] board, String word) {

    char[] chars = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (dfs(board, chars, i, j, 0)) return true;
      }
    }
    return false;
  }

  public boolean dfs(char[][] board, char[] chars, int i, int j, int k) {
    if (i < 0
        || i >= board.length
        || j < 0
        || j >= board[0].length
        || board[i][j] != chars[k]) // board[i][j] != chars[k]必须放最后，"或"的短路效应
    return false;
    if (k == chars.length - 1) return true;
    board[i][j] = '/';
    boolean res =
        dfs(board, chars, i + 1, j, k + 1)
            || dfs(board, chars, i, j + 1, k + 1)
            || dfs(board, chars, i - 1, j, k + 1)
            || dfs(board, chars, i, j - 1, k + 1);
    board[i][j] = chars[k];
    return res;
  }
}
