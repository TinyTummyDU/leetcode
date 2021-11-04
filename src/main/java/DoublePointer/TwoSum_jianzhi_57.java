package DoublePointer;

public class TwoSum_jianzhi_57 {

  //    剑指 Offer 57. 和为s的两个数字
  //    输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

  public static void main(String[] args) {
    System.out.println(123);
  }

  // 对撞双指针，首尾双指针
  public int[] twoSum(int[] nums, int target) {
    int i = 0;
    int j = nums.length - 1;
    int sum = 0;
    while (i != j) {
      sum = nums[i] + nums[j];
      // 提醒一下，判断条件最好不要用相加后的结果，
      // 应该用target - nums[i] 跟 nums[j]比较，这样保证不会溢出。
      // 虽然这题中不会出错。同样的例子还有二分查找，(left + right) / 2 可以用left + ((rigth - left) >> 1))代替
      if (sum < target) {
        i++;
        continue;
      }
      if (sum > target) {
        j--;
        continue;
      }
      break;
    }
    return new int[] {nums[i], nums[j]};
  }
}
