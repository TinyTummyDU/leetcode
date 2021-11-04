package string;

import java.util.Arrays;

public class MinNumForArray {
  // 剑指 45

  public static String minNumber(int[] nums) {
    String[] strs = new String[nums.length];
    for (int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);
    fastSort(strs, 0, strs.length - 1);
    StringBuilder res = new StringBuilder();
    for (String s : strs) res.append(s);
    return res.toString();
  }

  public static void fastSort(String[] strs, int l, int r) {
    if (l >= r) return;
    int i = l, j = r;
    String tmp = strs[l];
    while (i < j) { // i!=j
      while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
      while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
      tmp = strs[i];
      strs[i] = strs[j];
      strs[j] = tmp;
    }
    strs[l] = strs[i]; // 这里 i j 都一样，因为只要跳出上面的循环，i==j
    strs[l] = tmp;
    fastSort(strs, l, i - 1);
    fastSort(strs, i + 1, r);
  }

  public static void main(String[] args) {
    int[] test = {6, 30, 34, 5, 9};
    String res = minNumber(test);
    System.out.println(res);

    char[] test1 = {'T', 'i', 'm'};
    System.out.println(test1.toString());
    System.out.println(new String(test1));
    System.out.println(String.valueOf(test1));
  }

  // sort
  public String minNumber1(int[] nums) {
    String[] strs = new String[nums.length];
    for (int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);
    Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
    StringBuilder res = new StringBuilder();
    for (String s : strs) res.append(s);
    return res.toString();
  }
}
