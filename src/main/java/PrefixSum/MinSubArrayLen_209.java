package PrefixSum;

import java.util.Arrays;

public class MinSubArrayLen_209 {

  //    209 长度最小的子数组
  //    给定一个含有 n 个正整数的数组和一个正整数 target 。
  //    找出该数组中满足其和 ≥ target 的长度最小的 连续子数组。并返回其长度。如果不存在符合条件的子数组，返回 0
  //
  // https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/javade-jie-fa-ji-bai-liao-9985de-yong-hu-by-sdwwld/
  //    一共五种方法

  // 4.二分法查找
  public static int minSubArrayLen3(int s, int[] nums) {
    int length = nums.length;
    int min = Integer.MAX_VALUE;
    int[] sums = new int[length + 1];
    for (int i = 1; i <= length; i++) {
      sums[i] = sums[i - 1] + nums[i - 1];
    }
    for (int i = 0; i <= length; i++) { // 这里i=0很重要，比如[1,2,3,4,5],s=15
      int target = s + sums[i];
      System.out.println(i + " " + target);
      int index = Arrays.binarySearch(sums, target);
      if (index < 0) index = ~index;
      System.out.println("index: " + index);
      if (index <= length) { // 比如[1,2,3,4,5],s=15，如果找不到目标target，就会返回length+1 这里也就是6，所以我们要加入这个if语句
        min = Math.min(min, index - i);
      }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }

  public static void main(String[] args) {
    //        int[] nums = {1,2,3,4,5};
    //        System.out.println(minSubArrayLen3(15, nums));

    Integer a1 = new Integer(42);
    System.out.println(Integer.toBinaryString(a1));

    int mid = ~a1;
    System.out.println("反");
    System.out.println(Integer.toBinaryString(mid));
    System.out.println(mid);

    System.out.println("补");
    int j = -a1;
    System.out.println(Integer.toBinaryString(j));
  }

  // 暴力解法
  public int minSubArrayLen(int s, int[] nums) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      int sum = nums[i];
      if (sum >= s) {
        return 1;
      }
      for (int j = i + 1; j < nums.length; j++) {
        sum += nums[j];
        if (sum >= s) {
          min = Math.min(min, j - i + 1);
          break; // 暴力解法当前最小了，break
        }
      }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }

  // .使用队列相加（实际上我们也可以把它称作是滑动窗口，这里的队列其实就相当于一个窗口） 其实我也觉得可以是双指针
  public int minSubArrayLen1(int s, int[] nums) {
    int lo = 0, hi = 0, sum = 0, min = Integer.MAX_VALUE;
    while (hi < nums.length) {
      sum += nums[hi++];
      while (sum >= s) {
        min = Math.min(min, hi - lo);
        sum -= nums[lo++];
      }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }

  // 使用队列相减（实际上我们也可以把它称作是滑动窗口，这里的队列其实就相当于一个窗口） 其实我也觉得可以是双指针
  public int minSubArrayLen2(int s, int[] nums) {
    int lo = 0, hi = 0, target = s, min = Integer.MAX_VALUE;
    while (hi < nums.length) {
      target -= nums[hi++];
      while (target <= 0) { // 即sum>=s
        min = Math.min(min, hi - lo);
        target += nums[lo++];
      }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }

  // 直接使用窗口
  public int minSubArrayLen4(int s, int[] nums) {
    int lo = 1, hi = nums.length, min = 0;
    while (lo <= hi) {
      int mid = (lo + hi) >> 1;
      if (windowExist(mid, nums, s)) {
        hi = mid - 1; // 找到就缩小窗口的大小
        min = mid; // 如果找到就记录下来
      } else lo = mid + 1; // 没找到就扩大窗口的大小
    }
    return min;
  }

  // size窗口的大小
  private boolean windowExist(int size, int[] nums, int s) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i >= size) sum -= nums[i - size];
      sum += nums[i];
      if (sum >= s) return true;
    }
    return false;
  }
}
