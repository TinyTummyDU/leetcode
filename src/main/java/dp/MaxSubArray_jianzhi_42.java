package dp;

public class MaxSubArray_jianzhi_42 {

  //    剑指 Offer 42. 连续子数组的最大和
  //    输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
  //    要求时间复杂度为O(n)。

  //    1 <= arr.length <= 10^5
  //    -100 <= arr[i] <= 100

  public int maxSubArray(int[] nums) {
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      nums[i] += Math.max(0, nums[i - 1]);
      max = Math.max(max, nums[i]);
    }
    return max;
  }

  //    思路很清晰，只是有一点建议。 因为有的时候，题目要求可能不能修改原有数组，考虑到在dp列表中，
  //    dp[i]只和dp[i-1]有关,所以用两个参数存储循环过程中的dp[i]和dp[i-1]的值即可，空间复杂度也为o(1)
}
