package MeiTuan;

import java.util.Scanner;

public class SubString {
  // 题目描述
  // EFFEEF max = 2 e-f

  private static int max = 0;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String s = in.next();
    char[] arr = s.toCharArray();

    // 非递归
    //        int maxE = bigE(arr, n);
    //        System.out.println(maxE);

    // 递归
    recur(arr, n - 1);
    System.out.println(max);
  }

  private static int bigE(char[] arr, int n) {
    int pre = 0;
    int max = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] == 'E') max = Math.max(max, ++pre);
      else pre = Math.max(0, pre - 1);
    }
    return max;
  }

  private static int recur(char[] arr, int i) {
    if (i < 0) {
      return 0;
    }
    char cur = arr[i];
    if (cur == 'E') {
      int swap = recur(arr, i - 1) + 1;
      max = Math.max(swap, max);
      return swap;
    } else {
      return Math.max(0, recur(arr, i - 1) - 1);
    }
  }
}
