package array;

import java.util.HashSet;
import java.util.Set;

public class FindTwoNumberSumSInAIncreasingSeries {

  //    输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

  // 对撞双指针
  public int[] twoSum(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    int[] res = new int[0];
    while (l != r) {
      if (nums[l] + nums[r] > target) {
        r--;
      } else if (nums[l] + nums[r] < target) {
        l++;
      } else {
        return new int[] {nums[l], nums[r]};
      }
    }
    return res;
  }

  // hashtable
  public int[] twoSum1(int[] nums, int target) {
    // hash表法
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    for (int num : nums) {
      int e = target - num;
      if (set.contains(e)) {
        return new int[] {num, e};
      }
    }
    return new int[] {};
  }

  // 二分法
  public int[] twoSum2(int[] nums, int target) {
    for (int i = 0; i < nums.length; ++i) {
      int left = i + 1, right = nums.length - 1, e = target - nums[i];
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == e) {
          return new int[] {nums[i], nums[mid]};
        } else if (nums[mid] > e) {
          right = mid - 1;
        } else if (nums[mid] < e) {
          left = mid + 1;
        }
      }
    }
    return new int[] {};
  }
}
