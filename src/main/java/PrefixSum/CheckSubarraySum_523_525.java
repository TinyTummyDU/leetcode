package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class CheckSubarraySum_523_525 {

  // 523. 连续的子数组和

  // 方法一：前缀和 + 哈希表  同余定理
  public static boolean checkSubarraySum(int[] nums, int k) {
    int m = nums.length;
    if (m < 2) {
      return false;
    }
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    map.put(0, -1);
    int remainder = 0;
    for (int i = 0; i < m; i++) {
      remainder = (remainder + nums[i]) % k;
      System.out.println("i: " + i + " remainder: " + remainder);
      if (map.containsKey(remainder)) {
        int prevIndex = map.get(remainder);
        if (i - prevIndex >= 2) {
          return true;
        }
      } else {
        map.put(remainder, i);
      }
    }
    return false;
  }

  public static boolean checkSubarraySum1(int[] nums, int k) {
    int m = nums.length;
    if (m < 2) return false;
    int[] sums = new int[m + 1];
    for (int i = 1; i < m + 1; i++) {
      sums[i] = sums[i - 1] + nums[i - 1];
      System.out.print(sums[i] + " ");
    }

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    map.put(0, 0);
    int remainder = 0;
    for (int i = 1; i < m + 1; i++) {
      remainder = sums[i] % k;
      System.out.println("i: " + i + " remainder: " + remainder);
      if (map.containsKey(remainder)) {
        int preIndex = map.get(remainder);
        if (i - preIndex >= 2) {
          return true;
        }
      } else {
        map.put(remainder, i);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    //        int[] test = {0,1,0,3,0,4,0,4,0};
    int[] test = {0, 0, 1, 3, 0, 4, 0, 4, 0}; // 注意，就一开始的两个0就可以满足条件了
    //        checkSubarraySum1(test,5);
    checkSubarraySum(test, 5);
  }
}
