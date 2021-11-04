package dp;

public class TargetSum {

  // 目标和
  // 494

  // 递归，枚举
  int count;

  public int findTargetSumWays(int[] nums, int S) {

    calculate(nums, 0, 0, S);
    return count;
  }

  private void calculate(int[] nums, int i, int sum, int s) {
    if (i == nums.length) {
      if (sum == s) {
        count++;
      }
    } else {
      calculate(nums, i + 1, sum + nums[i], s);
      calculate(nums, i + 1, sum - nums[i], s);
    }
  }
}
