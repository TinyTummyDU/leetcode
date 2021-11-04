package DoublePointer;

/**
 * @ClassName: JudgeSquareSum_633 @Description: todo @Author Yuqi Du @Date 2021/10/31 9:02
 * 上午 @Version 1.0
 */
public class JudgeSquareSum_633 {
  public static boolean judgeSquareSum(int c) {
    int l = 0;
    int r = (int) Math.sqrt(c);
    while (l <= r) {
      if (l * l + r * r == c) {
        return true;
      } else if (l * l + r * r > c) {
        r--;
      } else {
        l++;
      }
    }
    System.out.println(l);
    System.out.println(r);
    return false;
    //      2147483600
  }

  public static void main(String[] args) {
    judgeSquareSum(2147483600);
  }

  // 双指针 O(genhaon) O(1) 防止溢出
  public boolean judgeSquareSum2(int c) {
    int a = 0, b = (int) Math.sqrt(c);
    while (a <= b) {
      int cur = a * a + b * b - c;
      if (cur == 0) {
        return true;
      } else if (cur > 0) {
        b--;
      } else {
        a++;
      }
    }
    return false;
  }

  // 枚举 O(genhaon) O(1)
  public boolean judgeSquareSum1(int c) {
    int max = (int) Math.sqrt(c);
    for (int a = 0; a <= max; a++) {
      int b = (int) Math.sqrt(c - a * a);
      if (a * a + b * b == c) return true;
    }
    return false;
  }

  // 费马定理
  public boolean judgeSquareSum3(int c) {
    for (int base = 2; base * base <= c; base++) {
      // 如果不是因子，枚举下一个
      if (c % base != 0) {
        continue;
      }
      // 计算 base 的幂
      int exp = 0;
      while (c % base == 0) {
        c /= base;
        exp++;
      }
      // 根据 Sum of two squares theorem 验证
      if (base % 4 == 3 && exp % 2 != 0) {
        return false;
      }
    }
    // 例如 11 这样的用例，由于上面的 for 循环里 base * base <= c ，base == 11 的时候不会进入循环体
    // 因此在退出循环以后需要再做一次判断
    return c % 4 != 3;
  }
}
