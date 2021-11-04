package general;

public class TakingCoins {

  public static void main(String[] args) {
    int a = 2;
    a >>= 3;
    System.out.println(a); // 右移多了 就变成 0

    int b = 1;
    b <<= 2;
    System.out.println(b);

    System.out.println("****************");
    int num1 = 9;
    int num2 = 5;
    System.out.println(num1 / num2); // 低精度向高精度转换，隐式转换
  }

  //    当a和b符号一致时，求模运算和求余运算所得的c的值一致，因此结果一致。
  //    当符号不一致时，结果不一样。求模运算结果的符号和b一致，求余运算结果的符号和a一致。
  //    另外各个环境下%运算符的含义不同，比如c/c++，java 为取余，而python则为取模。

  public int minCount(int[] coins) {

    int minimum = 0;
    for (int n : coins) {
      if (n % 2 == 0) {
        minimum += n / 2;
      } else {
        minimum += n / 2 + 1;
      }
    }
    return minimum;
  }
}
