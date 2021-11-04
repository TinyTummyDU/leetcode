package dp;

public class Fibonacci_jianzhi_10 {

  public static void main(String[] args) {
    //        -7 Mod 4
    int a = -7;
    int b = 4;
    System.out.println(a % 4);
    System.out.println(Integer.toBinaryString(a));
    System.out.println(~(7));
  }

  //    写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
  //    F(0) = 0 F(1)= 1
  //    F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
  //    斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
  //    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
  public int fib(int n) {
    if (n == 0) return 0;
    int[] res = new int[n];
    res[0] = 0;
    res[1] = 1;
    for (int i = 2; i < n; i++) {
      res[i] = res[i - 1] + res[i - 2];
      res[i] %= 1000000007;
    }
    return res[n - 1];
  }

  // 空间复杂度为o(1)的版本
  public int fib1(int n) {
    int a = 0, b = 1, sum = 1;
    for (int i = 1; i <= n; i++) {
      sum = (a + b) % 1000000007;
      a = b;
      b = sum;
    }
    return a;
  }
}
