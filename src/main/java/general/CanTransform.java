package general;

public class CanTransform {

  // 777. 在LR字符串中交换相邻字符

  public static boolean canTransform(String start, String end) {

    int len = start.length();

    // 转换不变性
    if (!start.replace("X", "").equals(end.replace("X", ""))) {
      return false;
    }
    // 可到达性
    int t = 0;
    for (int i = 0; i < len; i++) {
      if (start.charAt(i) == 'L') {
        while (end.charAt(t) != 'L') {
          t++;
        }
        if (i < t) {
          return false;
        }
        t++; // 匹配到了，那么就i和j都要递增
      }
    }
    t = 0;
    for (int i = 0; i < len; i++) {
      if (start.charAt(i) == 'R') {
        while (end.charAt(t) != 'R') {
          t++;
        }
        if (i > t) {
          return false;
        }
        t++; // 匹配到了，那么就i和j都要递增
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String start = "RXXLRXRXL";
    String end = "XRLXXRRLX";

    System.out.println(start.replace("X", ""));
    System.out.println(start.replace("X", "").equals(end.replace("X", "")));
    //        if (!start.replace("X", "").equals(end.replace("X", "")))
    //            System.out.println(false);

    //        String start = "X";
    //        String end = "L";
    //        System.out.println(canTransform(start,end));
  }

  // 使用双指针，还是围绕转换不变性和可到达性
  public boolean canTransform1(String start, String end) {
    int N = start.length();
    char[] S = start.toCharArray(), T = end.toCharArray();
    int i = 0, j = 0;
    while (i < N || j < N) { // 这个地方才对
      while (i < N && S[i] == 'X') i++;
      while (j < N && T[j] == 'X') j++;
      if ((i < N) ^ (j < N)) return false;

      if (i < N && j < N) {
        if (S[i] != T[j] || (S[i] == 'L' && i < j) || (S[i] == 'R' && i > j)) return false;
      }
      ++i;
      ++j;
    }

    return true;
  }
}
