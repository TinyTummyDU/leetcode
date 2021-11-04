package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraysDivByK_974_523 {

  // 974. 和可被 K 整除的子数组
  // 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。

  //    输入：A = [4,5,0,-2,-3,1], K = 5
  //    输出：7
  //    解释：
  //    有 7 个子数组满足其元素之和可被 K = 5 整除：
  //            [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
  // 1,1,1,0,0,0,0

  //
  // https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/solution/he-ke-bei-k-zheng-chu-de-zi-shu-zu-by-leetcode-sol/

  // 个人题解，余数
  public static int subarraysDivByK(int[] nums, int k) {
    int length = nums.length;
    int sums[] = new int[length + 1];
    for (int i = 1; i < length + 1; i++) {
      sums[i] = nums[i - 1] + sums[i - 1];
      System.out.print(sums[i] + " ");
    }
    System.out.println();
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 0); // 余为0的sums现在有0个
    for (int i = 1; i < length + 1; i++) {
      int remainder = sums[i] % k;
      if (map.containsKey(remainder)) {
        int value = map.get(remainder);
        map.put(remainder, value + 1);
      } else {
        map.put(remainder, 1); // 以前没有这个余数出现，就初始化为一个
      }
    }
    int res = 0;
    for (int i : map.values()) { // 两两组合
      if (i > 1) {
        long ans1 = (fact(2) * (fact(i - 2)));
        long ans2 = fact(i);
        System.out.print(ans2 / ans1 + " ");
        res += ans2 / ans1;
      }
    }
    System.out.println();
    return res;
  }

  // 个人题解，余数
  public static int subarraysDivByK2(int[] nums, int k) {
    int length = nums.length;
    int sums[] = new int[length + 1];
    for (int i = 1; i < length + 1; i++) {
      sums[i] = nums[i - 1] + sums[i - 1];
      System.out.print(sums[i] + " ");
    }
    System.out.println();
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1); // 余为0的sums现在有1个
    for (int i = 1; i < length + 1; i++) {
      //            int remainder = Math.abs(sums[i]%k);
      int remainder = (sums[i] % k + k) % k;
      if (map.containsKey(remainder)) {
        int value = map.get(remainder);
        map.put(remainder, value + 1);
      } else {
        map.put(remainder, 1); // 以前没有这个余数出现，就初始化为一个
      }
    }
    int res = 0;
    for (int i : map.values()) { // 两两组合
      System.out.print(i + " ");
      if (i > 1) {
        long ans1 = (fact(2) * (fact(i - 2)));
        long ans2 = fact(i);
        res += ans2 / ans1;
      }
    }
    System.out.println();
    return res;
  }

  public static long fact(long n) { // 阶乘
    long sum = 1;
    for (int i = 2; i <= n; i++) {
      sum *= i;
    }
    return sum;
  }

  public static int subarraysDivByK3(int[] nums, int k) {
    int length = nums.length;
    int sums[] = new int[length + 1];
    for (int i = 1; i < length + 1; i++) {
      sums[i] = nums[i - 1] + sums[i - 1];
      System.out.print(sums[i] + " ");
    }
    System.out.println();
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1); // 余为0的sums现在有1个
    int res = 0;
    for (int i = 1; i < length + 1; i++) {
      int remainder = (sums[i] % k + k) % k;
      if (map.containsKey(remainder)) {
        int value = map.get(remainder);
        res += value;
        map.put(remainder, value + 1);
      } else {
        map.put(remainder, 1); // 以前没有这个余数出现，就初始化为一个
      }
    }
    return res;
  }

  public static void main(String[] args) {
    //            int a = -5;
    //            int l = 2;
    //            System.out.println(a%l);

    //        int[] test = {4,5,0,-2,-3,1};
    //        System.out.println(subarraysDivByK2(test,5));
    //
    //            int x = ((-2 % 6) + 6) % 6;
    //            System.out.println(x);
    //            int y = Math.abs(-2%6);
    //            System.out.println(y);
    //

    int a = -2;
    int c = 6;
    System.out.println(a % 6);
  }
}
