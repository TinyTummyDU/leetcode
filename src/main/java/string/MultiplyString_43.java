package string;

/**
 * @ClassName: MultiplyString_43 @Description: todo @Author Yuqi Du @Date 2021/10/31 3:03
 * 下午 @Version 1.0
 */
public class MultiplyString_43 {

  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    // 保存计算结果
    String res = "0";
    // num2 逐位与 num1 相乘
    for (int i = num2.length() - 1; i >= 0; i--) {
      int carry = 0;
      // 保存 num2 第i位数字与 num1 相乘的结果
      StringBuilder temp = new StringBuilder();
      // 补 0
      for (int j = 0; j < num2.length() - 1 - i; j++) {
        temp.append(0);
      }
      int n2 = num2.charAt(i) - '0';
      // num2 的第 i 位数字 n2 与 num1 相乘
      for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) { // 这个也是关键
        int n1 = j < 0 ? 0 : num1.charAt(j) - '0'; // 这个是关键
        int product = (n1 * n2 + carry) % 10;
        temp.append(product);
        carry = (n1 * n2 + carry) / 10;
      }
      // 将当前结果与新计算的结果求和作为新的结果
      res = addStrings(res, temp.reverse().toString());
    }
    return res;
  }

  public String addStrings(String num1, String num2) {
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
}
