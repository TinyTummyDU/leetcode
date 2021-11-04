package bit_operation;

public class HammingWeight {
  // you need to treat n as an unsigned value

  public static void main(String[] args) {
    System.out.println(hammingWeight1(11));
  }

  public static int hammingWeight1(int n) {
    int count = 0;
    while (n != 0) {
      count += n & 1;
      n = n >>> 1;
    }
    return count;
  }

  //    二进制字符串统计法
  public int hammingWeight(int n) {

    if (n == 0) return 0;
    int count = 0;
    String str_n = Integer.toBinaryString(n);
    char[] chars = str_n.toCharArray();
    for (char c : chars) {
      if (c == '1') {
        count++;
      }
    }
    return count;
  }
}
