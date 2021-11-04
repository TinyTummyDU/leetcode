package dfs_bfs;

public class PathInMatrix {

  public boolean major(char[][] board, String word) {

    char[] words = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (dfs_self(board, words, i, j, 0)) return true;
      }
    }
    return false;
  }

  public boolean dfs_self(char[][] board, char[] word, int i, int j, int k) {
    if ((i < 0)
        || (j < 0)
        || (i >= board.length)
        || (j >= board[0].length)
        || (word[k] != board[i][j])) {
      return false;
    }
    if (k == word.length - 1) {
      return true;
    }
    char temp = board[i][j];
    board[i][j] = '/';
    boolean res =
        (dfs_self(board, word, i + 1, j, k + 1)
            || dfs_self(board, word, i - 1, j, k + 1)
            || dfs_self(board, word, i, j + 1, k + 1)
            || dfs_self(board, word, i, j - 1, k + 1));
    board[i][j] = temp;
    return res;
  }

  public boolean exist(char[][] board, String word) {
    char[] words = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (dfs(board, words, i, j, 0)) return true;
      }
    }
    return false;
  }

  boolean dfs(char[][] board, char[] word, int i, int j, int k) {
    if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k])
      return false;
    if (k == word.length - 1) return true;
    char tmp = board[i][j];
    board[i][j] = '/';
    boolean res =
        dfs(board, word, i + 1, j, k + 1)
            || dfs(board, word, i - 1, j, k + 1)
            || dfs(board, word, i, j + 1, k + 1)
            || dfs(board, word, i, j - 1, k + 1);
    board[i][j] = tmp;
    return res;
  }
}
