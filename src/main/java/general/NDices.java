package general;

public class NDices {
  public static double[] twoSum(int n) {
    double pre[] = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
    for (int i = 2; i <= n; i++) {
      // 为n的数组概率
      double mid[] = new double[6 * i - i + 1];
      for (int j = 0; j < pre.length; j++) {
        for (int a = 0; a < 6; a++) {
          // 为(n-1)和1的数组概率计算
          mid[j + a] += pre[j] * (1 / 6d);
        }
      }
      // 为n-1的数组概率
      pre = mid;
    }
    return pre;
  }

  public static void main(String[] args) {
    double[] res = twoSum(2);
    for (int i = 0; i < res.length; i++) {
      System.out.println(res[i]);
    }
  }
}
