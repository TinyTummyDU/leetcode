package math;

/**
 * @ClassName: TrailingZeroes @Description: todo @Author Yuqi Du @Date 2021/11/1 1:13 下午 @Version
 * 1.0
 */
public class TrailingZeroes_172 {
  //    Given an integer n, return the number of trailing zeroes in n!.

  // logarithmic
  public int trailingZeroes(int n) {
    int res = 0;
    long curMultiple = 5;
    while (n >= curMultiple) {
      res += n / curMultiple;
      curMultiple *= 5;
    }
    return res;
  }

  public int trailingZeroes1(int n) {
    int zeroCount = 0;
    while (n > 0) {
      n /= 5;
      zeroCount += n;
    }
    return zeroCount;
  }

  // o(n)
  public int trailingZeroes2(int n) {
    int zeroCount = 0;
    for (int i = 5; i <= n; i += 5) {
      int powerOf5 = 5;
      while (i % powerOf5 == 0) {
        zeroCount += 1;
        powerOf5 *= 5;
      }
    }
    return zeroCount;
  }
}
