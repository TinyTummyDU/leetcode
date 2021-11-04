package general;

public class BlackAndWhiteGrid {

  public static int combinate(int i, int n) {
    if (i == 0) return 1;
    int res = 1;
    int res1 = 1;
    for (int j = i; j > 0; j--) {
      res *= n;
      n--;
      res1 *= j;
    }
    return res / res1;
  }

  public static void main(String[] args) {
    System.out.println(combinate(4, 5));
  }

  public int paintingPlan(int n, int k) {

    int res = 0;
    // 边界
    if (k == n * n) return 1;
    if (k == 0) return 1;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if ((i * n) + (j * n) - (i * j) == k) {
          res += combinate(i, n) * combinate(j, n);
        }
      }
    }
    return res;
  }
}
