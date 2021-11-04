package general;

public class ValidSudocu {

  // 36

  public boolean isValidSudoku(char[][] board) {
    int[][] rows = new int[9][10]; // 9行，每一行10个数，0不用，是为了，比如9在第一行出现过，那么 rows[0][9] = 1
    int[][] columns = new int[9][10];
    int[][] chunks = new int[9][10];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') continue;
        int curNumber = board[i][j] - '0';
        if (rows[i][curNumber] == 1
            || columns[j][curNumber] == 1
            || chunks[j / 3 + (i / 3) * 3][curNumber] == 1) {
          return false;
        }
        rows[i][curNumber] = 1; // 之前都没出现过，现在出现了，就给它置为1，下次再遇见就能够直接返回false了。
        columns[j][curNumber] = 1;
        chunks[j / 3 + (i / 3) * 3][curNumber] = 1;
      }
    }
    return true;
  }
}
