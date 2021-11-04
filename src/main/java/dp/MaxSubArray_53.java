package dp;

public class MaxSubArray_53 {

  public int maxSubArray(int[] nums) {
    int res = nums[0];
    for (int i = 1; i < nums.length; i++) {
      nums[i] += Math.max(nums[i - 1], 0);
      res = Math.max(res, nums[i]);
    }
    return res;
  }

  public int by_myself(int[] nums) {
    int res = nums[0];
    for (int i = 1; i < nums.length; i++) {
      nums[i] += Math.max(nums[i - 1], 0);
      res = Math.max(nums[i], res);
    }
    return res;
  }

  //    思路很清晰，只是有一点建议。
  // 因为有的时候，题目要求可能不能修改原有数组，考虑到在dp列表中，dp[i]只和dp[i-1]有关,所以用两个参数存储循环过程中的dp[i]和dp[i-1]的值即可，空间复杂度也为
  ////        o(1)
  //
  //    public int by_myself1(int[] nums){
  //
  //
  //    }

}
