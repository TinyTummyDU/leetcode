package array;

import java.util.Arrays;

public class FindRepeatNumber_jianzhi_03 {

  //
  // https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-yua/
  // 原地交换
  public int findRepeatNumber1(int[] nums) {
    int len = nums.length;
    int i = 0;
    while (i < len) {
      if (nums[i] == i) {
        i++;
        continue;
      }
      if (nums[nums[i]] == nums[i]) return nums[i];
      int temp = nums[i];
      nums[i] = nums[temp];
      nums[temp] = temp;
    }
    return -1;
  }

  // 排序
  public int findRepeatNumber(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) return nums[i];
    }
    return 0;
  }
}
