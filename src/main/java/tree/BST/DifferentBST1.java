package tree.BST;

public class DifferentBST1 {
  // 96

  public int numTrees(int n) {

    int[] res = new int[n + 1];
    res[0] = 1; // 因为一会儿要使用乘法，来做笛卡尔积，所以必须是1
    res[1] = 1;

    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        res[i] = res[j - 1] * res[i - j];
      }
    }
    return res[n];
  }
}
