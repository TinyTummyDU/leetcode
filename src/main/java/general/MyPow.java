package general;

public class MyPow {

  public double myPow(double x, int n) {
    double res = 1.0;
    if (n == 0) return 1;
    for (int i = n; i != 0; i /= 2, x *= x) {
      if (i % 2 != 0) {
        // i是奇数
        res *= x;
      }
    }
    return n < 0 ? 1 / res : res;
  }
}
