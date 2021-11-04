package matrix;

public class Transpose {

  public static void main(String[] args) {
    int[][] a = new int[10][10];
    System.out.println(a[0][0]);
    Integer[] b = new Integer[2];
    b[0] = 1;
    System.out.println(b[0]);
  }

  public int[][] transpose(int[][] matrix) {
    int row = matrix.length;
    int column = matrix[0].length;

    int[][] newM = new int[column][row];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        newM[j][i] = matrix[i][j];
      }
    }
    return newM;
  }
}
