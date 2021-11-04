package array;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence {

  //    输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
  //
  //    序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

  public static void main(String[] args) {
    System.out.println(3 / 2);
  }

  public int[][] findContinuousSequence(int target) {

    int l = 1;
    int r = 1;
    // 左右窗口边界
    int sum = 1;
    List<int[]> res = new ArrayList<>();
    while (l < target / 2) {
      if (sum < target) {
        // r 右移
        r++;
        sum += r;
      } else if (sum > target) {
        // l 右移
        l++;
        sum -= l - 1;
      } else {
        // 记录一个结果
        int[] cur = new int[r - l + 1];
        for (int k = 0; k <= r - l; k++) {
          cur[k] = r + k;
        }
        res.add(cur);

        r++; // r 右移，找下一个匹配项
      }
    }

    int[][] res1 = new int[res.size()][];
    for (int i = 0; i < res.size(); i++) {
      res1[i] = res.get(i);
    }
    //        return res.toArray(new int[res.size()][]);
    return res1;
  }
}
