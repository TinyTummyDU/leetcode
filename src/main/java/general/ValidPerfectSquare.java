package general;

public class ValidPerfectSquare {

  // Newton Iteration
  public static boolean isPerfectSquare1(int num) {
    if (num < 2) return true;

    long x = num / 2;
    System.out.println(x);
    while (x * x > num) {
      x = (x + num / x) / 2;
      System.out.println(x);
    }
    return (x * x == num);
  }

  public static void main(String[] args) {
    System.out.println(5 / 2);
    isPerfectSquare1(5);
  }

  // 二分
  public boolean isPerfectSquare(int num) {
    if (num < 2) {
      return true;
    }

    long left = 2, right = num / 2, x, guessSquared;
    while (left <= right) {
      x = left + (right - left) / 2;
      guessSquared = x * x;
      if (guessSquared == num) {
        return true;
      }
      if (guessSquared > num) {
        right = x - 1;
      } else {
        left = x + 1;
      }
    }
    return false;
  }
}
