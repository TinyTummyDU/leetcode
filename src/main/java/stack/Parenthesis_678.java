package stack;

import java.util.Stack;

/**
 * @ClassName: Parenthesis_678 @Description: todo @Author Yuqi Du @Date 2021/10/26 10:05 上午 @Version
 * 1.0
 */
public class Parenthesis_678 {

  // dp
  public static boolean dp(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '*') {
        dp[i][i] = true;
      }
    }
    for (int i = 0; i < n - 1; i++) {
      if (((s.charAt(i) == '(') || (s.charAt(i) == '*'))
          && ((s.charAt(i + 1) == ')') || (s.charAt(i + 1) == '*'))) {
        dp[i][i + 1] = true;
      }
    }
    for (int i = n - 3; i >= 0; i--) {
      for (int j = i + 2; j < n; j++) {
        if (((s.charAt(i) == '(') || (s.charAt(i) == '*'))
            && ((s.charAt(j) == ')') || (s.charAt(j) == '*'))) {
          dp[i][j] = dp[i + 1][j - 1];
          if (!dp[i][j]) { // 这里是关键
            for (int k = i; k < j; k++) {
              dp[i][j] = dp[i][k] && dp[k + 1][j]; // 这里是关键
              if (dp[i][j]) break;
            }
          }
        }
      }
    }
    return dp[0][n - 1];
  }

  // two stacks
  public static boolean checkValidString(String s) {
    Stack<Integer> leftP = new Stack<>();
    Stack<Integer> star = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        leftP.push(i);
      } else if (s.charAt(i) == '*') {
        star.push(i);
      } else {
        if (!leftP.isEmpty()) {
          leftP.pop();
        } else if (!star.isEmpty()) {
          star.pop();
        } else {
          return false;
        }
      }
    }
    while (!leftP.isEmpty()) {
      if (star.isEmpty()) {
        return false;
      } else {
        if (leftP.pop() > star.pop()) {
          return false;
        }
      }
    }
    return true;
  }

  // greedy
  public static boolean greedy(String s) {
    int minCount = 0, maxCount = 0;
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (c == '(') {
        minCount++;
        maxCount++;
      } else if (c == ')') {
        minCount = Math.max(minCount - 1, 0);
        maxCount--;
        if (maxCount < 0) {
          return false;
        }
      } else {
        minCount = Math.max(minCount - 1, 0);
        maxCount++;
      }
    }
    return minCount == 0;
  }

  public static void main(String[] args) {
    String a =
        "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
    System.out.println(checkValidString(a));

    String b =
        "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
    System.out.println(checkValidString(b));
  }
}
