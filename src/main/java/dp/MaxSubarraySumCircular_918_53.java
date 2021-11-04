package dp;

public class MaxSubarraySumCircular_918_53 {

  //
  // https://leetcode-cn.com/problems/maximum-sum-circular-subarray/solution/java-dp-kan-bu-dong-wei-shi-yao-sum-min-x7q53/
  // kanade算法
  public static int maxSubarraySumCircular(int[] A) {
    int dp = A[0];
    int max = A[0];
    int sum = A[0];
    for (int i = 1; i < A.length; i++) {
      sum += A[i];
      dp = A[i] + Math.max(0, dp); // 到i的最大自序和
      max = Math.max(max, dp);
    }
    System.out.println("sum: " + sum);
    System.out.println("max: " + max);

    dp = A[0]; // 从0开始就是怕越界，理论上要找的是1----len-1的最小子序列
    int min = 0; // 这个很重要，只有一个数的时候，相当于没有1----len-1的最小子序列
    for (int i = 1; i < A.length - 1; i++) {
      dp = A[i] + Math.min(dp, 0); // 积累的永远是 x<=0
      min = Math.min(dp, min);
    }
    System.out.println("min: " + min);
    return Math.max(sum - min, max);
  }

  public static void main(String[] args) {
    int[] a = {1, -2, 2, -4, 5};
    maxSubarraySumCircular(a);
  }
}
