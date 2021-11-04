package general;

import java.util.Arrays;

public class NextPermutation_31 {
  //    实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
  //    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
  //    必须 原地 修改，只允许使用额外常数空间。

  public static void main(String[] args) {
    int[] nums = new int[3];
    // 这种形式是对数组部分排序，也就是对数组a的下标从fromIndex到toIndex-1的元素排序，注意：下标为toIndex的元素不参与排序哦！
    Arrays.sort(nums, 1, 2);
  }

  public void nextPermutation(int[] nums) {
    int len = nums.length;
    if (len <= 1) return;

    for (int i = len - 1; i >= 1; i--) {
      if (nums[i] > nums[i - 1]) { // 找到第一个相邻的 后数大于前数
        for (int j = len - 1; j >= i; j--) {
          if (nums[j] > nums[i - 1]) { // 找到i及i后面第一个比i-1
            int swap = nums[j];
            nums[j] = nums[i - 1];
            nums[i - 1] = swap;
            break;
          }
        }
        Arrays.sort(nums, i, len);
        return;
      }
    }
    Arrays.sort(nums);
    return;
  }
}
