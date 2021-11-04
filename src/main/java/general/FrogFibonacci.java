package general;

public class FrogFibonacci {

  public int numWays(int n) {
    int a = 1, b = 1, sum;
    for (int i = 0; i < n; i++) {
      sum = (a + b) % 1000000007;
      a = b;
      b = sum;
    }
    return a;
  }

  public int numWays_byMyself(int n) {

    int first = 1;
    int second = 1;
    int third = 0;

    if (n == 0) {
      return first;
    }
    if (n == 1) {
      return second;
    }
    for (int i = 0; i < n - 1; i++) {
      third = (first + second) % 1000000007;
      first = second;
      second = third;
    }
    return third;
  }
}
