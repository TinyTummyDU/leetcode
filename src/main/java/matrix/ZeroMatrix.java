package matrix;

public class ZeroMatrix {

  // 面试题 01.08. 零矩阵

  public void setZeroes(int[][] matrix) {

    Boolean firstRow = false;
    Boolean firstColumn = false;
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        firstColumn = true;
        break;
      }
    }
    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        firstRow = true;
        break;
      }
    }
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = matrix[i][0] = 0;
        }
      }
    }

    // 不对，这样就把第一行第一列的也改变了

    //        for(int i = 0 ; i < matrix.length ; i++){
    //            if(matrix[i][0] == 0){
    //                for(int j = 1 ; j<matrix[0].length; j++){
    //                    matrix[i][j]=0;
    //                }
    //            }
    //        }
    //        for(int i = 0 ; i < matrix[0].length ; i++){
    //            if(matrix[0][i] == 0){
    //                for(int j = 1 ; j<matrix.length; j++){
    //                    matrix[j][i]=0;
    //                }
    //            }
    //        }

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[0][j] == 0 || matrix[i][0] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    if (firstColumn) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
    if (firstRow) {
      for (int i = 0; i < matrix[0].length; i++) {
        matrix[0][i] = 0;
      }
    }
  }
}
