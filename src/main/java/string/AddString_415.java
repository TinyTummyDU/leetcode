package string;

/**
 * @ClassName: AddString_415 @Description: todo @Author Yuqi Du @Date 2021/10/30 7:27 下午 @Version
 * 1.0
 */
public class AddString_415 {

  //  Given two non-negative integers, num1 and num2 represented as string, return the sum of num1
  // and num2 as a string.
  //  You must solve the problem without using any built-in library for handling large integers
  // (such as BigInteger).
  //  You must also not convert the inputs to integers directly.

  public static String addStrings(String num1, String num2) {
    StringBuilder stringBuilder = new StringBuilder();
    int maxLen = Math.max(num1.length(), num2.length());
    int carrier = 0;
    for (int i = 0; i < maxLen; i++) {
      int a1 = i >= num1.length() ? 0 : ((int) num1.charAt(num1.length() - 1 - i) - '0');
      int a2 = i >= num2.length() ? 0 : ((int) num2.charAt(num2.length() - 1 - i) - '0');
      carrier = (a1 + a2) / 10;
      stringBuilder.append((carrier + a1 + a2) % 10);
    }
    if (carrier == 1) {
      stringBuilder.append(1);
    }
    System.out.println(stringBuilder.toString());
    return stringBuilder.reverse().toString();
  }

  public String addStrings2(String num1, String num2) {
    StringBuilder res = new StringBuilder("");
    int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
    while (i >= 0 || j >= 0) {
      int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
      int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
      int tmp = n1 + n2 + carry;
      carry = tmp / 10;
      res.append(tmp % 10);
      i--;
      j--;
    }
    if (carry == 1) res.append(1);
    return res.reverse().toString();
  }

  public static void main(String[] args) {
    String a1 = "191";
    String a2 = " 99";
    System.out.println(addStrings(a1, a2));
  }

  public String addStrings1(String num1, String num2) {
    int len = Math.max(num1.length(), num2.length());
    int len1 = num1.length();
    int len2 = num2.length();
    String smaller = len1 < len2 ? num1 : num2;
    String bigger = len1 < len2 ? num2 : num1;
    int[] res = new int[len + 1]; // there maybe is a final carrier bit
    int carrier = 0;
    int bitOfSmaller = 0;
    // int bitOfBigger = 0;
    for (int i = 0; i < len; i++) {
      if (i >= smaller.length()) {
        bitOfSmaller = 0;
      } else {
        bitOfSmaller = (int) (smaller.charAt(smaller.length() - 1 - i) - '0');
      }
      int cur = carrier + bitOfSmaller + (int) (bigger.charAt(bigger.length() - 1 - i) - '0');
      res[i] = cur % 10;
      carrier = cur / 10;
    }
    StringBuilder s = new StringBuilder();
    if (carrier == 1) {
      s.append(1);
    }
    for (int i = len - 1; i >= 0; i--) {
      s.append(res[i]);
    }

    return s.toString();
  }
}
