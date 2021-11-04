package DoublePointer;

public class RemoveDuplicates_80 {

  // 删除有序数组中的重复项 II
  //    给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
  //    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

  public int removeDuplicates(int[] nums) {
    return process(nums, 2);
  }

  public int process(int[] nums, int k) {
    int count = 0;
    for (int num : nums) {
      if (count < k || num != nums[count - k]) nums[count++] = num;
    }
    return count;
  }
}
