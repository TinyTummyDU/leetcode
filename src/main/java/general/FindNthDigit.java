package general;

public class FindNthDigit {

  // 剑指offer 44
  public static int findNthDigit(int n) {
    if (n == 0) return 0;

    int digit = 1;
    // 下面两个必须是long，不然会int溢出
    long start = 1;
    long count = digit * 9 * start;

    while (n > count) {
      n = (int) (n - count); // 先剪了前面的
      digit++;
      start *= 10;
      count = digit * 9 * start;
    }

    long num = start + (n - 1) / digit;
    int bit = (n - 1) % digit;
    String numString = String.valueOf(num);
    int res = numString.charAt(bit) - '0';
    System.out.println(res);
    return res;
  }

  public static void main(String[] args) {
    findNthDigit(1000000);
  }
}
