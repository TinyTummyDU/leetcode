package dp;

public class TranslateNumIntoString_jianzhi_46 {

  //    剑指 Offer 46. 把数字翻译成字符串
  // 这个题就是 有条件的青蛙跳格子，有条件的斐波那契

  //    给定一个数字，我们按照如下规则把它翻译为字符串：
  //            0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
  //    一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
  //
  //    输入: 12258
  //    输出: 5
  //    解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
  //

  public static int translateNum(int num) {
    String numString = String.valueOf(num);
    //        char[] res = String.valueOf(num).toCharArray(); 这样也可以
    int len = numString.length();
    int[] dp = new int[len];
    dp[0] = 1;
    if (len >= 2) {
      if (25 >= Integer.parseInt(numString.substring(0, 2))) {
        dp[1] = 2;
      } else {
        dp[1] = 1;
      }
    }
    // 0-25 也就是最多就是两位
    for (int i = 2; i < len; i++) {
      if (0 != Integer.parseInt(String.valueOf(numString.charAt(i - 1)))
          && 25 >= Integer.parseInt(numString.substring(i - 1, i + 1))) {
        dp[i] = dp[i - 1] + dp[i - 2];
      } else {
        dp[i] = dp[i - 1];
      }
    }
    return dp[len - 1];
  }

  public static void main(String[] args) {
    //        String a = "12";
    //        System.out.println(Integer.parseInt(a));
    //        -128-127
    //        10000000
    System.out.println(translateNum(624));
  }
}
