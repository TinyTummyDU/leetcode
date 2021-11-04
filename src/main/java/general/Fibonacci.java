package general;

public class Fibonacci {
  public static int fib(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;

    int first = 0;
    int second = 1;
    int third = 0;
    for (int i = 0; i < n - 1; i++) {
      third = (first + second) % 1000000007;
      first = second;
      second = third;
    }

    return third;
  }

  //    class Solution {
  //        public int fib(int n) {
  //            int a = 0, b = 1, sum;
  //            for(int i = 0; i < n; i++){
  //                sum = (a + b) % 1000000007;
  //                a = b;
  //                b = sum;
  //            }
  //            return a;
  //        }
  //    }

  public static void main(String[] args) {
    System.out.println((fib(4)));
    System.out.println((fib(7)));
    System.out.println((fib(48)));
  }
}
