package DoublePointer;

public class EvenOddExange_jianzhi_21 {

  //    剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
  //    输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

  // 首尾双指针
  public int[] exchange(int[] nums) {
    int i = 0;
    int j = nums.length - 1;
    while (i < j) { // 不可以用i!=j nums.len=0的话 不可以进循环
      if (nums[i] % 2 == 1) {
        i++;
        continue;
      }
      if (nums[j] % 2 == 0) {
        j--;
        continue;
      }
      int swap = nums[i];
      nums[i] = nums[j];
      nums[j] = swap;
    }
    return nums;
  }

  // 快慢双指针
  public int[] exchange1(int[] nums) {
    if (nums.length <= 1) return nums;
    int i = 0;
    int j = 0;
    while (j < nums.length) {
      if (nums[j] % 2 == 1) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
        i++;
      }
      j++;
    }
    return nums;
  }
}
